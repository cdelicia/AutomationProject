@smoke
Feature: Actual points for submission


  Background:
    Given I open "Login" page
    And I should see page title contains "Assessment Control"
    Then I sign in as a "Milan Teacher"
    And I wait for element with xpath "//header/div" to be present
    And element with xpath "//header/div/h3" should contain text "Milan Teacher"


  Scenario: Teacher can see actual point after student submit the assignment
    Then I click on element with xpath "//h5[contains(text(),'Submissions')]"
    And I wait for 2 sec
    Then I click on element using JavaScript with xpath "//div[contains(text(),'Reviewed')]"
    And The element with xpath "//mat-tab-group[@class='mat-tab-group mat-primary']" should be presented
    And I wait for 2 sec
    Then I click on element with xpath "//td[contains(text(), 'SQA1')]/ancestor::tr//button"
    And I wait for element with xpath "//td[contains(text(),'Actual points / percentage:')]" to be present
    And The element with xpath "//td[contains(text(),'20 of 20 / 100%')]" should be presented


  Scenario: Give assignment to single student
    When I click on element with xpath "//h5[contains(text(),'Assignments')]"
    Then The element with xpath "//mat-card[@class='page mat-card']" should be presented
    And I click on element using JavaScript with xpath "//span[contains(text(),'Create New Assignment')]"
    Then The element with xpath "//mat-card[@class='page mat-card']" should be presented
    Then I wait for 1 sec
    Then I click on element with xpath "//mat-select[@placeholder='Select Quiz To Assign']"
    Then I wait for 1 sec
    Then I click on element with xpath "//span[contains(text(),'0001 Quiz from Mountain#@')]"
    Then I click on element with xpath "//span[contains(text(), '1347')]"
    Then I click on element with xpath "//span[contains(text(),'Give Assignment')]"


  Scenario: Give assignment to multiple student
    When I click on element with xpath "//h5[contains(text(),'Assignments')]"
    Then The element with xpath "//mat-card[@class='page mat-card']" should be presented
    And I click on element using JavaScript with xpath "//span[contains(text(),'Create New Assignment')]"
    Then The element with xpath "//mat-card[@class='page mat-card']" should be presented
    Then I wait for 1 sec
    Then I click on element with xpath "//mat-select[@placeholder='Select Quiz To Assign']"
    Then I wait for 1 sec
    Then I click on element with xpath "//span[contains(text(),'0001 Quiz from Mountain#@')]"
    And I click on element with xpath "//span[contains(text(),'Select All')]"
    Then I click on element with xpath "//span[contains(text(),'Give Assignment')]"
    Then I wait for 1 sec
    Then element with xpath "//mat-card[@class='page mat-card']" should contain text "0001 Quiz from Mountain#@"


  Scenario: Assign assignment without quiz selection
    When I click on element with xpath "//h5[contains(text(),'Assignments')]"
    Then The element with xpath "//mat-card[@class='page mat-card']" should be presented
    And I click on element using JavaScript with xpath "//span[contains(text(),'Create New Assignment')]"
    Then The element with xpath "//mat-card[@class='page mat-card']" should be presented
    Then I wait for 1 sec
    And I click on element with xpath "//span[contains(text(),'Select All')]"
    Then I click on element with xpath "//span[contains(text(),'Give Assignment')]"
    Then I wait for 1 sec
    Then element with xpath "//mat-error[contains(text(),'This field is required')]" should contain text "This field is required"


  Scenario: Assign assignment without selecting student name
    When I click on element with xpath "//h5[contains(text(),'Assignments')]"
    Then The element with xpath "//mat-card[@class='page mat-card']" should be presented
    And I click on element using JavaScript with xpath "//span[contains(text(),'Create New Assignment')]"
    Then The element with xpath "//mat-card[@class='page mat-card']" should be presented
    Then I wait for 1 sec
    Then I click on element with xpath "//mat-select[@placeholder='Select Quiz To Assign']"
    Then I wait for 1 sec
    Then I click on element with xpath "//span[contains(text(),'0001 Quiz from Mountain#@')]"
    Then I click on element with xpath "//span[contains(text(),'Give Assignment')]"
    Then I wait for 1 sec
    Then element with xpath "//mat-error[contains(text(),'Select at least one Student')]" should contain text "Select at least one Student"















      

    