package com.daggerok.jbossboot.controller;

import com.daggerok.jbossboot.domain.PojoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PojoRestService {
    @Resource
    private PojoRepository pojoRepository;

    @RequestMapping("/")
    public String sayHello() {
        return null == pojoRepository ? "JBoss Boot" : "JBoss Boot v.1." + pojoRepository.count();
    }
}
