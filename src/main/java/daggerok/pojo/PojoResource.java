package daggerok.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
public class PojoResource {

  private final PojoRepository pojoRepository;

  @Autowired
  public PojoResource(final PojoRepository pojoRepository) {
    this.pojoRepository = pojoRepository;
  }

  @RequestMapping
  public ResponseEntity get() {
    return ResponseEntity.ok(pojoRepository.findAll());
  }

  @RequestMapping(method = POST)
  public ResponseEntity post(@RequestBody @Valid final Pojo pojo) {

    final Pojo target = pojoRepository.findFirstByNameContainingIgnoreCase(pojo.getName());
    if (null != target) return ResponseEntity.ok(target);

    final Pojo body = pojoRepository.save(pojo);
    return ResponseEntity.accepted()
                         .body(body);
  }
}
