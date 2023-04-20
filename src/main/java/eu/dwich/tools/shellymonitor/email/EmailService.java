package eu.dwich.tools.shellymonitor.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

  private final JavaMailSender emailSender;

  public EmailService(JavaMailSender emailSender) {
    this.emailSender = emailSender;
  }

  public void sendSimpleMessage(String from, String to, String subject, String text) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(from);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    emailSender.send(message);
  }
}
