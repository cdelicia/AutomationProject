@smoke1
Feature: New User Registration and Activation

  Scenario Outline: Student registration
    Given I open url "http://ask-int.portnov.com/#/registration"
    And I type "<firstName>" into the input field "First Name"
    And I type "<lastName>" into the input field "Last Name"
    And I type "<email>" into the input field "Email"
    And I type "<group>" into the input field "Group Code"
    And I type "<password>" into the input field "Password"
    And I type "<password>" into the input field "Confirm Password"
    Then I click on the button "Register Me"
    Then I retrieve data from the Database for user with email "<email>"
    Then I activate the user
    Examples:
      | firstName | lastName | email          | group | password |
      | Axl       | Rose     | auto-generated | test  | 12345$   |