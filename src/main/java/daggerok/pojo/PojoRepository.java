package daggerok.pojo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PojoRepository extends JpaRepository<Pojo, Long> {

  Pojo findFirstByNameContainingIgnoreCase(final String name);
}
