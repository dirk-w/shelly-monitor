package eu.dwich.tools.shellymonitor.scheduler;

import eu.dwich.tools.shellymonitor.service.CheckShellyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledTask {

  private final CheckShellyService checkShellyService;

  public ScheduledTask(CheckShellyService pShellyService) {
    this.checkShellyService = pShellyService;
  }


  @Scheduled(cron = "${eu.dwich.scheduler.cron}")
  public void checkShellyStatus() {
    log.info("CheckShellyStatus started");
    this.checkShellyService.checkShellyIsSwitched();
    log.info("CheckShellyStatus finished");
  }

}
