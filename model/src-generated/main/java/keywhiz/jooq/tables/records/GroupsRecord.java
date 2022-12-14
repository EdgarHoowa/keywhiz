/*
 * This file is generated by jOOQ.
 */
package keywhiz.jooq.tables.records;


import keywhiz.jooq.tables.Groups;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GroupsRecord extends UpdatableRecordImpl<GroupsRecord> implements Record9<Long, String, Long, Long, String, String, String, String, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>keywhizdb_test.groups.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>keywhizdb_test.groups.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>keywhizdb_test.groups.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>keywhizdb_test.groups.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>keywhizdb_test.groups.updatedat</code>.
     */
    public void setUpdatedat(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>keywhizdb_test.groups.updatedat</code>.
     */
    public Long getUpdatedat() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>keywhizdb_test.groups.createdat</code>.
     */
    public void setCreatedat(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>keywhizdb_test.groups.createdat</code>.
     */
    public Long getCreatedat() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>keywhizdb_test.groups.description</code>.
     */
    public void setDescription(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>keywhizdb_test.groups.description</code>.
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>keywhizdb_test.groups.createdby</code>.
     */
    public void setCreatedby(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>keywhizdb_test.groups.createdby</code>.
     */
    public String getCreatedby() {
        return (String) get(5);
    }

    /**
     * Setter for <code>keywhizdb_test.groups.updatedby</code>.
     */
    public void setUpdatedby(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>keywhizdb_test.groups.updatedby</code>.
     */
    public String getUpdatedby() {
        return (String) get(6);
    }

    /**
     * Setter for <code>keywhizdb_test.groups.metadata</code>.
     */
    public void setMetadata(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>keywhizdb_test.groups.metadata</code>.
     */
    public String getMetadata() {
        return (String) get(7);
    }

    /**
     * Setter for <code>keywhizdb_test.groups.owner</code>.
     */
    public void setOwner(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>keywhizdb_test.groups.owner</code>.
     */
    public Long getOwner() {
        return (Long) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, Long, Long, String, String, String, String, Long> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, String, Long, Long, String, String, String, String, Long> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Groups.GROUPS.ID;
    }

    @Override
    public Field<String> field2() {
        return Groups.GROUPS.NAME;
    }

    @Override
    public Field<Long> field3() {
        return Groups.GROUPS.UPDATEDAT;
    }

    @Override
    public Field<Long> field4() {
        return Groups.GROUPS.CREATEDAT;
    }

    @Override
    public Field<String> field5() {
        return Groups.GROUPS.DESCRIPTION;
    }

    @Override
    public Field<String> field6() {
        return Groups.GROUPS.CREATEDBY;
    }

    @Override
    public Field<String> field7() {
        return Groups.GROUPS.UPDATEDBY;
    }

    @Override
    public Field<String> field8() {
        return Groups.GROUPS.METADATA;
    }

    @Override
    public Field<Long> field9() {
        return Groups.GROUPS.OWNER;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Long component3() {
        return getUpdatedat();
    }

    @Override
    public Long component4() {
        return getCreatedat();
    }

    @Override
    public String component5() {
        return getDescription();
    }

    @Override
    public String component6() {
        return getCreatedby();
    }

    @Override
    public String component7() {
        return getUpdatedby();
    }

    @Override
    public String component8() {
        return getMetadata();
    }

    @Override
    public Long component9() {
        return getOwner();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Long value3() {
        return getUpdatedat();
    }

    @Override
    public Long value4() {
        return getCreatedat();
    }

    @Override
    public String value5() {
        return getDescription();
    }

    @Override
    public String value6() {
        return getCreatedby();
    }

    @Override
    public String value7() {
        return getUpdatedby();
    }

    @Override
    public String value8() {
        return getMetadata();
    }

    @Override
    public Long value9() {
        return getOwner();
    }

    @Override
    public GroupsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public GroupsRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public GroupsRecord value3(Long value) {
        setUpdatedat(value);
        return this;
    }

    @Override
    public GroupsRecord value4(Long value) {
        setCreatedat(value);
        return this;
    }

    @Override
    public GroupsRecord value5(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public GroupsRecord value6(String value) {
        setCreatedby(value);
        return this;
    }

    @Override
    public GroupsRecord value7(String value) {
        setUpdatedby(value);
        return this;
    }

    @Override
    public GroupsRecord value8(String value) {
        setMetadata(value);
        return this;
    }

    @Override
    public GroupsRecord value9(Long value) {
        setOwner(value);
        return this;
    }

    @Override
    public GroupsRecord values(Long value1, String value2, Long value3, Long value4, String value5, String value6, String value7, String value8, Long value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GroupsRecord
     */
    public GroupsRecord() {
        super(Groups.GROUPS);
    }

    /**
     * Create a detached, initialised GroupsRecord
     */
    public GroupsRecord(Long id, String name, Long updatedat, Long createdat, String description, String createdby, String updatedby, String metadata, Long owner) {
        super(Groups.GROUPS);

        setId(id);
        setName(name);
        setUpdatedat(updatedat);
        setCreatedat(createdat);
        setDescription(description);
        setCreatedby(createdby);
        setUpdatedby(updatedby);
        setMetadata(metadata);
        setOwner(owner);
    }
}
