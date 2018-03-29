package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class Application {

  /**
   * because of WAR...
   */
  @Configuration
  public static class WARConfig extends SpringBootServletInitializer {

    @Bean
    public DispatcherServlet dispatcherServlet() {
      return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(final DispatcherServlet dispatcherServlet) {
      final ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet, "/*");
      registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
      return registration;
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
      return application.sources(Application.class);
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
