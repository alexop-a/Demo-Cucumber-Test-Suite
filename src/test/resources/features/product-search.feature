@grocery-app
@product-search
Feature: Product Search
  As a user of the grocery app
  I want to search for products
  So that I can quickly find items to add to my cart

  Scenario Outline: Successful <product> product search
    Given the app is launched
    And I am logged in as "<username>"
    When I enter "<product>" in the search bar
    And I tap on the "Search" button
    Then I should see results related to "<product>"

    Examples: 
      | username | product     |
      | shopper1 | apples      |
      | shopper2 | almond milk |
      | shopper3 | chicken     |

  Scenario: No search results for invalid product
    Given the app is launched
    And I am logged in as "shopper1"
    When I enter "xyz123" in the search bar
    And I tap on the "Search" button
    Then I should see a message "No results found"
