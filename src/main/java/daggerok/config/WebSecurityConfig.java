package daggerok.config;

import daggerok.domain.props.AppProps;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.inject.Inject;

/**
 * There really isn’t much to this configuration, but it does a lot. You can find a summary of the features below:
 * <p>
 * Require authentication to every URL in your application
 * Generate a login form for you
 * Allow the user with the Username admin and the Password admin to authenticate with form based authentication
 * Allow the user to logout
 * CSRF attack prevention
 * Session Fixation protection
 * User Header integration
 * <p>
 * HTTP Strict Transport User for secure requests
 * X-Content-Type-Options integration
 * Cache Control (can be overridden later by your application to allow caching of your static resources)
 * X-XSS-Protection integration
 * X-Frame-Options integration to help prevent Clickjacking
 * Integrate with the following Servlet API methods
 * <p>
 * HttpServletRequest#getRemoteUser()
 * HttpServletRequest.html#getUserPrincipal()
 * HttpServletRequest.html#isUserInRole(java.lang.String)
 * HttpServletRequest.html#login(java.lang.String, java.lang.String)
 * HttpServletRequest.html#logout()
 */
//@Order(-1)
@EnableWebSecurity
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final AppProps props;

  @Bean
  public UserDetailsService userDetailsService() {

    final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    final AppProps.User user = props.getUser();

    manager.createUser(User.withUsername(user.getUsername())
                           .password(user.getPassword())
                           .roles(props.getUser()
                                       .getRoles()
                                       .toArray(new String[0]))
                           .build());
    return manager;
  }

  /**
   * Allow only /actuator/* endpoints
   *
   * @param web WebSecurity
   */
  @Override
  public void configure(final WebSecurity web) {
    web.ignoring().antMatchers("/actuator/?*");
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    super.configure(http);
    http.csrf().disable();
  }
}
