package daggerok.domain.pojo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonMap;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
public class PojoResource {

  private final PojoRepository pojoRepository;

  public PojoResource(final PojoRepository pojoRepository) {
    this.pojoRepository = pojoRepository;
  }

  @GetMapping
  @SneakyThrows
  public ResponseEntity root(final HttpServletRequest request) {

    final String scheme = request.getScheme();
    final String host = request.getServerName();
    final int port = request.getServerPort();
    final String path = request.getContextPath();
    final String url = format("%s://%s:%d/%s", scheme, host, port, path);

    return ok(asList(
        singletonMap("GET", url),
        singletonMap("POST", url)
    ));
  }

  @GetMapping({ "", "/" })
  public ResponseEntity get() {

    return null == pojoRepository
        ? badRequest().body(singletonMap("error", "O.o"))
        : ok(singletonMap("result", pojoRepository.findAll()));
  }

  @PostMapping({"", "/" })
  public ResponseEntity post(@RequestBody @Valid final Pojo pojo) {
    final Pojo body = pojoRepository.save(pojo);
    return ResponseEntity.ok(body);
  }
}
