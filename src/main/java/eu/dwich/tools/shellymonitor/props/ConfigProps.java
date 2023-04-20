package eu.dwich.tools.shellymonitor.props;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ConfigProps {

  @Value("${eu.dwich.scheduler.cron}")
  private String cronString;

  @Value("${eu.dwich.shelly.url}")
  private String shellyUrl;

  @Value("${eu.dwich.notification.to}")
  private String notificationTo;

  @Value("${eu.dwich.notification.text}")
  private String notificationText;

  @Value("${eu.dwich.notification.from}")
  private String notificationFrom;


  public String getCronString() {
    return cronString;
  }

  public String getShellyUrl() {
    return shellyUrl;
  }

  public String getNotificationTo() {
    return notificationTo;
  }

  public String getNotificationText() {
    return notificationText;
  }

  public String getNotificationFrom() {
    return notificationFrom;
  }
}
