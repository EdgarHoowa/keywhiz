/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package keywhiz.service.resources.admin;

import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import io.dropwizard.auth.Auth;
import io.dropwizard.jersey.params.LongParam;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import keywhiz.api.CreateSecretRequest;
import keywhiz.api.SecretDetailResponse;
import keywhiz.api.automation.v2.CreateOrUpdateSecretRequestV2;
import keywhiz.api.model.Client;
import keywhiz.api.model.Group;
import keywhiz.api.model.SanitizedSecret;
import keywhiz.api.model.Secret;
import keywhiz.auth.User;
import keywhiz.service.daos.AclDAO;
import keywhiz.service.daos.AclDAO.AclDAOFactory;
import keywhiz.service.daos.SecretController;
import keywhiz.service.daos.SecretDAO;
import keywhiz.service.daos.SecretDAO.SecretDAOFactory;
import keywhiz.service.exceptions.ConflictException;
import keywhiz.service.resources.automation.v2.SecretResource;
import org.jooq.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.format;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @parentEndpointName secrets-admin
 *
 * @resourcePath /admin/secrets
 * @resourceDescription Create, retrieve, and delete secrets
 */
@Path("/admin/secrets")
@Produces(APPLICATION_JSON)
public class SecretsResource {
  private static final Logger logger = LoggerFactory.getLogger(SecretsResource.class);

  private final SecretController secretController;
  private final AclDAO aclDAO;
  private final SecretDAO secretDAO;

  @Inject public SecretsResource(SecretController secretController, AclDAOFactory aclDAOFactory, SecretDAOFactory secretDAOFactory) {
    this.secretController = secretController;
    this.aclDAO = aclDAOFactory.readwrite();
    this.secretDAO = secretDAOFactory.readwrite();
  }

  @VisibleForTesting SecretsResource(SecretController secretController, AclDAO aclDAO, SecretDAO secretDAO) {
    this.secretController = secretController;
    this.aclDAO = aclDAO;
    this.secretDAO = secretDAO;
  }

  /**
   * Retrieve Secret by a specified name and version, or all Secrets if name is not given
   *
   * @excludeParams user
   * @optionalParams name
   * @param name the name of the Secret to retrieve, if provided
   * @optionalParams version
   * @param nameOnly if set, the result only contains the id and name for the secrets.
   *
   * @description Returns a single Secret or a set of all Secrets for this user.
   * Used by Keywhiz CLI and the web ui.
   * @responseMessage 200 Found and retrieved Secret(s)
   * @responseMessage 404 Secret with given name not found (if name provided)
   */
  @Timed @ExceptionMetered
  @GET
  public Response findSecrets(@Auth User user, @DefaultValue("") @QueryParam("name") String name,
      @DefaultValue("") @QueryParam("nameOnly") String nameOnly) {
    if (name.isEmpty()) {
      if (nameOnly.isEmpty()) {
        return Response.ok().entity(listSecrets(user)).build();
      } else {
        return Response.ok().entity(listSecretsNameOnly(user)).build();
      }
    }
    return Response.ok().entity(retrieveSecret(user, name)).build();
  }

  protected List<SanitizedSecret> listSecrets(@Auth User user) {
    logger.info("User '{}' listing secrets.", user);
    return secretController.getSanitizedSecrets();
  }

  protected List<SanitizedSecret> listSecretsNameOnly(@Auth User user) {
    logger.info("User '{}' listing secrets.", user);
    return secretController.getSecretsNameOnly();
  }

  protected SanitizedSecret retrieveSecret(@Auth User user, String name) {
    logger.info("User '{}' retrieving secret name={}.", user, name);
    return sanitizedSecretFromName(name);
  }

  /**
   * Create Secret
   *
   * @excludeParams user
   * @param request the JSON client request used to formulate the Secret
   *
   * @description Creates a Secret with the name from a valid secret request.
   * Used by Keywhiz CLI and the web ui.
   * @responseMessage 200 Successfully created Secret
   * @responseMessage 400 Secret with given name already exists
   */
  @Timed @ExceptionMetered
  @POST
  @Consumes(APPLICATION_JSON)
  public Response createSecret(@Auth User user, @Valid CreateSecretRequest request) {

    logger.info("User '{}' creating secret '{}'.", user, request.name);

    Secret secret;
    try {
      SecretController.SecretBuilder builder =
          secretController.builder(request.name, request.content, user.getName(), request.expiry);

      if (request.description != null) {
        builder.withDescription(request.description);
      }

      if (request.metadata != null) {
        builder.withMetadata(request.metadata);
      }

      secret = builder.create();
    } catch (DataAccessException e) {
      logger.warn("Cannot create secret {}: {}", request.name, e);
      throw new ConflictException(format("Cannot create secret %s.", request.name));
    }

    URI uri = UriBuilder.fromResource(SecretsResource.class).path("{secretId}").build(secret.getId());
    return Response
        .created(uri)
        .entity(secretDetailResponseFromId(secret.getId()))
        .build();
  }

  /**
   * Create or update secret
   *
   * @excludeParams user
   * @param request the JSON client request used to formulate the Secret
   *
   * @responseMessage 200 Successfully created Secret
   */
  @Path("{name}")
  @Timed @ExceptionMetered
  @POST
  @Consumes(APPLICATION_JSON)
  public Response createOrUpdateSecret(@Auth User user, @PathParam("name") String secretName, @Valid CreateOrUpdateSecretRequestV2 request) {

    logger.info("User '{}' createOrUpdate secret '{}'.", user, secretName);

    Secret secret = secretController
        .builder(secretName, request.content(), user.getName(), request.expiry())
        .withDescription(request.description())
        .withMetadata(request.metadata())
        .withType(request.type())
        .createOrUpdate();

    URI uri = UriBuilder.fromResource(SecretsResource.class).path(secretName).build();

    return Response.created(uri).entity(secretDetailResponseFromId(secret.getId())).build();
  }


  /**
   * Retrieve Secret by ID
   *
   * @excludeParams user
   * @param secretId the ID of the secret to retrieve
   *
   * @description Returns a single Secret if found.
   * Used by Keywhiz CLI and the web ui.
   * @responseMessage 200 Found and retrieved Secret with given ID
   * @responseMessage 404 Secret with given ID not Found
   */
  @Path("{secretId}")
  @Timed @ExceptionMetered
  @GET
  public SecretDetailResponse retrieveSecret(@Auth User user,
      @PathParam("secretId") LongParam secretId) {

    logger.info("User '{}' retrieving secret id={}.", user, secretId);
    return secretDetailResponseFromId(secretId.get());
  }

  /**
   * Delete Secret by ID
   *
   * @excludeParams user
   * @param secretId the ID of the Secret to be deleted
   *
   * @description Deletes a single Secret if found.
   * Used by Keywhiz CLI and the web ui.
   * @responseMessage 200 Found and deleted Secret with given ID
   * @responseMessage 404 Secret with given ID not Found
   */
  @Path("{secretId}")
  @Timed @ExceptionMetered
  @DELETE
  public Response deleteSecret(@Auth User user, @PathParam("secretId") LongParam secretId) {
    Optional<Secret> secret = secretController.getSecretByIdOne(secretId.get());
    if (!secret.isPresent()) {
      logger.info("User '{}' tried deleting a secret which was not found (id={})", user, secretId.get());
      throw new NotFoundException("Secret not found.");
    }

    logger.info("User '{}' deleting secret id={}, name='{}'", user, secretId, secret.get().getName());

    secretDAO.deleteSecretsByName(secret.get().getName());
    return Response.noContent().build();
  }

  private SecretDetailResponse secretDetailResponseFromId(long secretId) {
    Optional<Secret> secrets = secretController.getSecretByIdOne(secretId);
    if (!secrets.isPresent()) {
      throw new NotFoundException("Secret not found.");
    }

    ImmutableList<Group> groups = ImmutableList.copyOf(aclDAO.getGroupsFor(secrets.get()));
    ImmutableList<Client> clients = ImmutableList.copyOf(aclDAO.getClientsFor(secrets.get()));
    return SecretDetailResponse.fromSecret(secrets.get(), groups, clients);
  }

  private SanitizedSecret sanitizedSecretFromName(String name) {
    Optional<Secret> optionalSecret = secretController.getSecretByNameOne(name);
    if (!optionalSecret.isPresent()) {
      throw new NotFoundException("Secret not found.");
    }

    Secret secret = optionalSecret.get();
    return SanitizedSecret.fromSecret(secret);
  }
}
