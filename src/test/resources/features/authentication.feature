@grocery-app
@authentication
Feature: User Login
  As a user of the grocery app
  I want to log into my account
  So that I can view and purchase items

  Scenario Outline: Successful login with valid credentials
    Given the app is launched
    When I enter "<username>" and "<password>"
    And I tap on the "Login" button
    Then I should see a welcome message with my username

    Examples: 
      | username   | password |
      | testuser1  | pass1234 |
      | shopper123 | qwerty12 |

  Scenario: Unsuccessful login with invalid credentials
    Given the app is launched
    When I enter "invaliduser" and "wrongpass"
    And I tap on the "Login" button
    Then I should see an error message "Invalid username or password"
