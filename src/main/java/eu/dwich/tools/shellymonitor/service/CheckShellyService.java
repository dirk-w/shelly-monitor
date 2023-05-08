package eu.dwich.tools.shellymonitor.service;

import eu.dwich.tools.shellymonitor.email.EmailService;
import eu.dwich.tools.shellymonitor.obj.ShellyValues;
import eu.dwich.tools.shellymonitor.props.ConfigProps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class CheckShellyService {

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
  private final ConfigProps configProps;
  private final RestTemplate restTemplate;
  private final EmailService emailService;

  public CheckShellyService(ConfigProps configProps, RestTemplate restTemplate, EmailService emailService) {
    this.configProps = configProps;
    this.restTemplate = restTemplate;
    this.emailService = emailService;
  }

  public void checkShellyIsSwitched(){
    log.debug("start checking shelly status, fetching URL: {}", configProps.getShellyUrl());
    try {
      ShellyValues shVals = restTemplate.getForObject(configProps.getShellyUrl(), ShellyValues.class);
      if(shVals != null && shVals.ison()){
        log.debug("shelly is on, nothing to do");
      } else {
        String subject = "checking shelly failed on : [" + dateFormat.format(new Date()) + "] please check";
        log.info("shelly is not on, sending E-Mail for notification");
          sendMail(subject, configProps.getNotificationText());
      }
    } catch (ResourceAccessException e) {
      sendMail("Failed with ResourceAccessException [" + dateFormat.format(new Date()) + "] please check", configProps.getNotificationText());
    }
    log.debug("checking shelly status finished");
  }

  private void sendMail(String pSubject, String pNotificationText) {
    this.emailService.sendSimpleMessage(
      configProps.getNotificationFrom(),
      configProps.getNotificationTo(),
      pSubject,
      pNotificationText);
  }
}
