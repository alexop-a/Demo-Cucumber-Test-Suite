package io.github.alexopa.democucumber.steps;

import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.alexopa.democucumber.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSteps {

	@Autowired
	private RandomUtil randomUtil;

	@Given("the app is launched")
	public void theAppIsLaunched() {
		log.info("App is launched");
		randomUtil.stepDelay();
	}

	@When("I enter {string} and {string}")
	public void iEnterUsernameAndPassword(String username, String password) {
		log.info("Entered username: {}", username);
		log.info("Entered password: {}", password);
		randomUtil.stepDelay();
	}

	@When("I tap on the {string} button")
	public void iTapOnTheButton(String buttonName) {
		log.info("Tapped on button: {}", buttonName);
		randomUtil.stepDelay();
	}

	@Then("I should see a welcome message with my username")
	public void iShouldSeeAWelcomeMessageWithMyUsername() {
		randomUtil.failRandomly();
		log.info("Welcome message displayed");
		randomUtil.stepDelay();
	}

	@Then("I should see an error message {string}")
	public void iShouldSeeAnErrorMessage(String errorMessage) {
		randomUtil.failRandomly();
		log.info("Error message displayed: {}", errorMessage);
		randomUtil.stepDelay();
	}
}
