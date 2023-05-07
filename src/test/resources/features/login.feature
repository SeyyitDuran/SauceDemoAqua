Feature: Login page with Aqua
@wip
  Scenario: Positive login test
    Given the user in on the login page
    When the user enters "standard_user" and "secret_sauce"
    Then the user should be able login successfully