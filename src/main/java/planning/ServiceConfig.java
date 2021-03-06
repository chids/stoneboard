package planning;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;

@Configuration
public class ServiceConfig {
  public static final String HOSTNAME_ENV = "GITHUB_HOSTNAME";
  public static final String DEFAULT_HOST = "github.com";

  @Value("${REPOSITORIES}")
  private String repositories;

  @Value("${" + HOSTNAME_ENV + ":" + DEFAULT_HOST + '}')
  private String hostname;

  public String hostname() {
    return requireNonNull(this.hostname).trim().isEmpty() ? DEFAULT_HOST : this.hostname;
  }

  public List<String> repositories() {
    return asList(requireNonNull(this.repositories).split(","));
  }
}
