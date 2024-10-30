package io.github.alexopa.democucumber.util;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.alexopa.democucumber.config.TestSuiteConfiguration;

@Component
public class RandomUtil {

	@Autowired
	private TestSuiteConfiguration testSuiteConfiguration;

	public void failRandomly() {
		if (ThreadLocalRandom.current().nextInt(0, 101) < testSuiteConfiguration.getFailThreashold()) {
			throw new RuntimeException();
		}
	}

	public void stepDelay() {
		long stepDelay = ThreadLocalRandom.current().nextLong(testSuiteConfiguration.getMinStepDurationDelay(),
				testSuiteConfiguration.getMaxStepDurationDelay());
		try {
			TimeUnit.MILLISECONDS.sleep(stepDelay);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
