package io.github.alexopa.democucumber.steps;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.alexopa.democucumber.context.TestContext;
import io.github.alexopa.democucumber.util.AttachmentUtil;

@CucumberContextConfiguration
@SpringBootTest(classes = { TestContext.class })
public class Hooks {
	
	@Autowired
	private AttachmentUtil attachmentUtil;
	
	@After(value = "@attach")
	public void attach(Scenario scenario) throws IOException {
		attachmentUtil.addAttachment(scenario);
	}
	
}
