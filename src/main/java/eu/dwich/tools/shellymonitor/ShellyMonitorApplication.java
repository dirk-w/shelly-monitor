package eu.dwich.tools.shellymonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ShellyMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShellyMonitorApplication.class, args);
	}

}
