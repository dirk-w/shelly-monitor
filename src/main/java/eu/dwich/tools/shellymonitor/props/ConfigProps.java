package eu.dwich.tools.shellymonitor.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ConfigProps {

  @Value("${eu.dwich.scheduler.cron}")
  private String cronString;

  public String getCronString() {
    return cronString;
  }
}
