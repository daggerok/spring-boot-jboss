package daggerok.war;

import daggerok.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WarInitializer extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }
}
