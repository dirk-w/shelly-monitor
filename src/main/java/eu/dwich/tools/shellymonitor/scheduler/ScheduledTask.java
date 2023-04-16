package eu.dwich.tools.shellymonitor.scheduler;

import eu.dwich.tools.shellymonitor.props.ConfigProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class ScheduledTask {

  private ConfigProps configProps;

  public ScheduledTask(ConfigProps configProps) {
    this.configProps = configProps;
  }

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(cron = "${eu.dwich.scheduler.cron}")
  public void reportCurrentTime() {
    log.info("The time is now {}", dateFormat.format(new Date()));
    log.info("CronString: {}", configProps.getCronString());
  }

}
