package daggerok.domain.props;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.security.Principal;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonMap;

@RestController
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class PropsResource {

  private final AppProps props;

  @GetMapping("/user")
  public ResponseEntity principal(final User user,
                                  final Principal principal,
                                  final UserDetails userDetails) {

    return ResponseEntity.ok(asList(
        singletonMap("user", user),
        singletonMap("principal", principal),
        singletonMap("userDetails", userDetails)
    ));
  }

  @GetMapping("/actuator/csrf")
  public CsrfToken csrf(final CsrfToken token) {
    return token;
  }

  @GetMapping("/actuator/system-props")
  public ResponseEntity getSystemProperties() {
    return ResponseEntity.ok(System.getProperties());
  }

  @GetMapping("/actuator/system-env")
  public ResponseEntity getSystemEnv() {
    return ResponseEntity.ok(System.getenv());
  }

  @GetMapping("/actuator/props")
  public ResponseEntity get() {
    return ResponseEntity.ok(props);
  }
}
