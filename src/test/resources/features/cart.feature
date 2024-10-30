@grocery-app
@cart
Feature: Adding Products to Cart
  As a user of the grocery app
  I want to add products to my cart
  So that I can review them before purchasing

  @attach @attach-text @attach-image
  Scenario Outline: Add single item to cart
    Given the app is launched
    And I am logged in as "<username>"
    And I have searched for "<product>"
    When I select "<product>"
    And I tap on the "Add to Cart" button
    Then "<product>" should appear in my cart

    Examples:
      | username   | product      |
      | shopperA   | bananas      |
      | shopperB   | yogurt       |
      | shopperC   | olive oil    |

  @attach @attach-json
  Scenario: Add multiple items to cart
    Given the app is launched
    And I am logged in as "shopperA"
    And I have searched for "eggs" and "bread"
    When I select "eggs"
    And I select "bread"
    And I tap on "Add to Cart" for each item
    Then both "eggs" and "bread" should appear in my cart
