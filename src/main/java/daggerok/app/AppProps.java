package daggerok.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component // @EnableConfigurationProperties(AppProps.class)
@ConfigurationProperties(prefix = "app")
public class AppProps {

  private HashMap random;

  public AppProps() { }

  public HashMap getRandom() {
    return random;
  }

  public void setRandom(final HashMap random) {
    this.random = random;
  }
}
