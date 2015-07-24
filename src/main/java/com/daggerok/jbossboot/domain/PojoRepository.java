package com.daggerok.jbossboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PojoRepository extends JpaRepository<Pojo, Long> {
}
