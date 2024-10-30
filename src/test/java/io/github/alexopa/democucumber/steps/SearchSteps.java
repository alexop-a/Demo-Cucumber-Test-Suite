package io.github.alexopa.democucumber.steps;

import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.alexopa.democucumber.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchSteps {

	@Autowired
	private RandomUtil randomUtil;

	@When("I enter {string} in the search bar")
	public void iEnterInTheSearchBar(String product) {
		log.info("Entered product: {}", product);
		randomUtil.stepDelay();
	}

	@When("I am logged in as {string}")
	public void iAmLoggedInAs(String username) {
		log.info("Logged in as: {}", username);
		randomUtil.stepDelay();
	}

	@Then("I should see results related to {string}")
	public void iShouldSeeResultsRelatedTo(String product) {
		randomUtil.failRandomly();
		log.info("Search results related to: {}", product);
		randomUtil.stepDelay();
	}

	@Then("I should see a message {string}")
	public void iShouldSeeAMessage(String message) {
		randomUtil.failRandomly();
		log.info("Displayed message: {}", message);
		randomUtil.stepDelay();
	}
}
