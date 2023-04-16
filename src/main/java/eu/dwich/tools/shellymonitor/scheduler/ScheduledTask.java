package eu.dwich.tools.shellymonitor.scheduler;

import eu.dwich.tools.shellymonitor.obj.ShellyValues;
import eu.dwich.tools.shellymonitor.props.ConfigProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class ScheduledTask {

  private final ConfigProps configProps;
  private final RestTemplate restTemplate;
  public ScheduledTask(ConfigProps pConfigProps, RestTemplate pRestTemplate) {
    this.configProps = pConfigProps;
    this.restTemplate = pRestTemplate;
  }

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(cron = "${eu.dwich.scheduler.cron}")
  public void reportCurrentTime() {
    log.info("The time is now {}", dateFormat.format(new Date()));
    log.info("CronString: {}", configProps.getCronString());
    log.info("fetching URL: {}", configProps.getShellyUrl());
    ShellyValues shVals = restTemplate.getForObject(configProps.getShellyUrl(), ShellyValues.class);
    log.info(shVals.toString());
  }

}
