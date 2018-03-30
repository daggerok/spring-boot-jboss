package daggerok.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonMap;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
public class ActuatorResource {

  private final AppProps props;

  @Autowired
  public ActuatorResource(final AppProps props) {
    this.props = props;
  }

  @RequestMapping({ "/info", "/health", "/**" })
  public ResponseEntity info(final HttpServletRequest request) {

    final String scheme = request.getScheme();
    final String host = request.getServerName();
    final int port = request.getServerPort();
    final String path = request.getContextPath();
    final String baseUrl = format("%s://%s:%d%s", scheme, host, port, path);

    return ResponseEntity.ok(asList(
        singletonMap("GET", baseUrl),
        singletonMap("POST", baseUrl),
        singletonMap("props", props)
    ));
  }
}
