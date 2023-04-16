package eu.dwich.tools.shellymonitor.obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShellyValues(boolean ison, boolean has_timer, long timer_started, String source) {
}
