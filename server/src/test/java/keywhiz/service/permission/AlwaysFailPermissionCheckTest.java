package keywhiz.service.permission;

import com.codahale.metrics.MetricRegistry;
import java.util.Objects;
import keywhiz.service.permissions.Action;
import keywhiz.service.permissions.AlwaysFailPermissionCheck;
import keywhiz.service.permissions.KeywhizPrincipal;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AlwaysFailPermissionCheckTest {
  MetricRegistry metricRegistry;
  AlwaysFailPermissionCheck alwaysFail;
  KeywhizPrincipal principal;
  Objects target;

  @Before
  public void setUp() {
    alwaysFail = new AlwaysFailPermissionCheck();
  }

  @Test
  public void isAllowedReturnsFalse() {
    boolean permitted = alwaysFail.isAllowed(principal, Action.ADD, target);
    assertThat(permitted).isEqualTo(false);
  }

  @Test
  public void checkAllowedOrThrowThrowsException() {
    assertThatThrownBy(() -> {alwaysFail.checkAllowedOrThrow(principal, Action.ADD, target);}).isInstanceOf(RuntimeException.class);
  }
}
