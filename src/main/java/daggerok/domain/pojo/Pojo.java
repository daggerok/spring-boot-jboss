package daggerok.domain.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class Pojo {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
}
