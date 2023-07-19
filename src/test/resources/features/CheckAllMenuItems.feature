@smoke
Feature: Home Page Links


  Background:
    Given I open "Login" page
    And I should see page title contains "Assessment Control"
    Then I sign in as a "volha teacher"
    Then I wait for element with xpath "//header/div" to be present
    Then element with xpath "//header/div/h3" should contain text "volha teacher"


  Scenario: Go to submissions
    Then I click on element with xpath "//span[contains(text(), 'Go To Submissions')]"
    And I wait for 1 sec
    Then I wait for element with xpath "//main//h4[contains(text(), 'Submissions')]" to be present


  Scenario: Go to Assignments
    Then I click on element with xpath "//span[contains(text(),'Go To Assignments')]"
    And I wait for 1 sec
    Then I wait for element with xpath "//h4[contains(text(),'List of Assignments')]" to be present


  Scenario: Go to Users Management
    Then I click on element with xpath "//span[contains(text(),'Go To Users Management')]"
    And I wait for 1 sec
    Then I wait for element with xpath "//h4[contains(text(),'Management')]" to be present


  Scenario: Go to submissions and Submissions from menu
    Then I click on element with xpath "//span[contains(text(), 'Go To Submissions')]"
    And I wait for 1 sec
    Then I wait for element with xpath "//h4[contains(text(),'Submissions')]" to be present
    Then I click on element with xpath "//mat-icon[contains(text(),'home')]"
    Then I should see page title contains "Assessment Control"
    And I click on element with xpath "//h5[contains(text(),'Submissions')]"
    Then I wait for element with xpath "//h4[contains(text(),'Submissions')]" to be present


  Scenario: Go to assignments and assignments from menu
    Then I click on element with xpath "//span[contains(text(),'Go To Assignments')]"
    And I wait for 1 sec
    Then I wait for element with xpath "//h4[contains(text(),'List of Assignments')]" to be present
    Then I click on element with xpath "//mat-icon[contains(text(),'home')]"
    Then I should see page title contains "Assessment Control"
    And I click on element with xpath "//h5[contains(text(),'Assignments')]"
    Then I wait for element with xpath "//h4[contains(text(),'List of Assignments')]" to be present


  Scenario: Go to Users management and Users management from menu
    Then I click on element with xpath "//span[contains(text(),'Go To Users Management')]"
    And I wait for 1 sec
    Then I wait for element with xpath "//h4[contains(text(),'Management')]" to be present
    Then I click on element with xpath "//mat-icon[contains(text(),'home')]"
    Then I should see page title contains "Assessment Control"
    And I click on element with xpath "//h5[contains(text(),'Management')]"
    Then I wait for element with xpath "//h4[contains(text(),'Management')]" to be present