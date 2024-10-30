package io.github.alexopa.democucumber.steps;

import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.alexopa.democucumber.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CartSteps {

	@Autowired
	private RandomUtil randomUtil;

	@When("I have searched for {string}")
	public void iHaveSearchedFor(String product) {
		log.info("Searched for product: {}", product);
		randomUtil.stepDelay();
	}

	@Given("I have searched for {string} and {string}")
	public void iHaveSearchedForAnd(String product1, String product2) {
		log.info("Searched for products: {} and {}", product1, product2);
		randomUtil.stepDelay();
	}

	@When("I select {string}")
	public void iSelect(String product) {
		log.info("Selected product: {}", product);
		randomUtil.stepDelay();
	}

	@When("I tap on {string} for each item")
	public void iTapOnForEachItem(String action) {
		log.info("Tapped on {} for each item", action);
		randomUtil.stepDelay();
	}

	@Then("{string} should appear in my cart")
	public void shouldAppearInMyCart(String product) {
		randomUtil.failRandomly();
		log.info("Prodcut {} is in the cart", product);
		randomUtil.stepDelay();
	}

	@Then("both {string} and {string} should appear in my cart")
	public void bothProductsShouldAppearInMyCart(String product1, String product2) {
		randomUtil.failRandomly();
		log.info("Products {} and {} are in the cart", product1, product2);
		randomUtil.stepDelay();
	}
}
