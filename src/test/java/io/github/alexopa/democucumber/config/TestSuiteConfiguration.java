package io.github.alexopa.democucumber.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "demo-cucumber.suite")
@Getter
@Setter
public class TestSuiteConfiguration {
	
	private int failThreashold = 10;
	
	private long minStepDurationDelay = 100L;
	
	private long maxStepDurationDelay = 1000;

}
