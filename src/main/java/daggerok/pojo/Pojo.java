package daggerok.pojo;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Pojo implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @NotBlank(message = "name may not be null or empty.")
  private final String name;

  protected Pojo() {
    this(-1L, "Default");
  }

  private Pojo(final Long id, final String name) {
    this.id = id;
    this.name = name;
  }

  public static Pojo of(final String name) {
    return new Pojo(null, name);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
