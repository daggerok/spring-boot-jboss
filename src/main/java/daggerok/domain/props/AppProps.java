package daggerok.domain.props;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProps {

  private String name, group, version, description;
  private UUID instanceId;
  private User user;

  @Data
  public static class User {
    private String username;
    @JsonIgnore private String password;
    private List<String> roles = new ArrayList<>();
  }
}
