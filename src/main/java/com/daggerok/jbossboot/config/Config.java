package com.daggerok.jbossboot.config;

import com.daggerok.jbossboot.Application;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan(basePackageClasses = { Application.class })
public class Config {
  @Bean
  public DispatcherServlet dispatcherServlet() {
    return new DispatcherServlet();
  }

  @Bean
  public ServletRegistrationBean dispatcherServletRegistration() {
    ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/*");

    registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
    return registration;
  }
}
