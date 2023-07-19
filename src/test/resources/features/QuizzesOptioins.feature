@smoke
Feature: Choose / Move / Add / Delete an Option in quizzes


  Scenario: Student is able to choose only one option in single choice question in quiz
    Given I open "Login" page
    Then I sign in as a "Chris"
    And I wait for element with xpath "//header/div" to be present
    And element with xpath "//header/div/h3" should contain text "Chris"
    Then I click on element with xpath "//h5[contains(text(),'My Assignments')]"
    And The element with xpath "//h4[contains(text(),'My Assignments')]" should be presented
    And I wait for 1 sec
    Then I click on element with xpath "//td[contains(text(), 'API OlgaG Quiz')]//following::span[1]"
    And The element with xpath "//h4[contains(text(), 'API OlgaG Quiz')]" should be presented
    Then I click on element with xpath "(//label[@class='mat-radio-label'])[1]"
    And element with xpath "//input[@id='mat-radio-2-input']" should be selected
    Then I click on element with xpath "(//label[@class='mat-radio-label'])[2]"
    And element with xpath "//input[@id='mat-radio-2-input']" should not be selected


  Scenario: Teacher moves option down
    Given I open "Login" page
    And I should see page title contains "Assessment Control"
    Then I sign in as a "Diana Brown"
    And I wait for element with xpath "//header/div" to be present
    And element with xpath "//header/div/h3" should contain text "Diana Brown"
    Then I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    And I wait for element with xpath "//h4[contains(text(),'List of Quizzes')]" to be present
    Then I click on element with xpath "//mat-panel-title[contains(text(),'001 Alex API Test Quiz')]"
    And I wait for 1 sec
    Then I click on element with xpath "//*[contains(text(),'001 Alex API Test Quiz')]//following::button[2]"
    And I wait for element with xpath "//input[@placeholder='Title Of The Quiz *']" to be present
    Then I click on element with xpath "//*[contains(text(),'What is your name?')]"
    And I wait for 1 sec
    Then I click on element with xpath "(//button[@class='mat-icon-button mat-accent'])[1]"
    And I wait for 1 sec
    Then I click on element with xpath "//button//span[text()='Move option down']"
    Then I click on element with xpath "//button/span[contains(text(),'Save')]"
    And I wait for element with xpath "//h4[text()='List of Quizzes']" to be present


  Scenario: Teacher moves option up
    Given I open "Login" page
    And I should see page title contains "Assessment Control"
    Then I sign in as a "Diana Brown"
    And I wait for element with xpath "//header/div" to be present
    And element with xpath "//header/div/h3" should contain text "Diana Brown"
    Then I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    And I wait for element with xpath "//h4[contains(text(),'List of Quizzes')]" to be present
    Then I click on element with xpath "//mat-panel-title[contains(text(),'001 Alex API Test Quiz')]"
    Then I click on element with xpath "//*[contains(text(),'001 Alex API Test Quiz')]//following::button[2]"
    And I wait for 1 sec
    Then I wait for element with xpath "//input[@placeholder='Title Of The Quiz *']" to be present
    Then I click on element with xpath "//*[contains(text(),'What is your name?')]"
    And I wait for 1 sec
    Then I click on element with xpath "(//button[@class='mat-icon-button mat-accent'])[1]"
    And I wait for 1 sec
    Then I click on element with xpath "//button//span[text()='Move option up']"
    Then I click on element with xpath "//button/span[contains(text(),'Save')]"
    And I wait for element with xpath "//h4[text()='List of Quizzes']" to be present


  Scenario: Teacher adds an option (answer) to question
    Given I open "Login" page
    And I should see page title contains "Assessment Control"
    Then I sign in as a "Diana Brown"
    Then I wait for element with xpath "//header/div" to be present
    Then element with xpath "//header/div/h3" should contain text "Diana Brown"
    Then I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    Then I wait for element with xpath "//h4[contains(text(),'List of Quizzes')]" to be present
    Then I click on element with xpath "//mat-panel-title[contains(text(),'001 Alex API Test Quiz')]"
    Then I click on element with xpath "//*[contains(text(),'001 Alex API Test Quiz')]//following::button[2]"
    Then I wait for element with xpath "//input[@placeholder='Title Of The Quiz *']" to be present
    Then I click on element with xpath "//*[contains(text(),'What is your name?')]"
    Then I wait for 2 sec
    Then I type "extra" into element with xpath "(//textarea[@placeholder='Option 3*'])[1]"
    Then I click on element with xpath "//button/span[contains(text(),'Save')]"
    Then I wait for element with xpath "//h4[text()='List of Quizzes']" to be present


  Scenario: Teacher deletes an option
    Given I open "Login" page
    And I should see page title contains "Assessment Control"
    Then I sign in as a "Diana Brown"
    And I wait for element with xpath "//header/div" to be present
    And element with xpath "//header/div/h3" should contain text "Diana Brown"
    Then I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    And I wait for element with xpath "//h4[contains(text(),'List of Quizzes')]" to be present
    Then I click on element with xpath "//mat-panel-title[contains(text(),'001 Alex API Test Quiz')]"
    Then I click on element with xpath "//*[contains(text(),'001 Alex API Test Quiz')]//following::button[2]"
    And I wait for element with xpath "//input[@placeholder='Title Of The Quiz *']" to be present
    Then I click on element with xpath "//*[contains(text(),'What is your name?')]"
    And I wait for 1 sec
    Then I click on element with xpath "(//button[@class='mat-icon-button mat-accent'])[1]"
    And I wait for 1 sec
    Then I click on element with xpath "//span[contains(text(),'Delete Option')]"
    Then I click on element with xpath "//button/span[contains(text(),'Save')]"
    And I wait for element with xpath "//h4[text()='List of Quizzes']" to be present


  Scenario: Teacher add an option back
    Given I open "Login" page
    And I should see page title contains "Assessment Control"
    Then I sign in as a "Diana Brown"
    And I wait for element with xpath "//header/div" to be present
    And element with xpath "//header/div/h3" should contain text "Diana Brown"
    Then I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    And I wait for element with xpath "//h4[contains(text(),'List of Quizzes')]" to be present
    Then I click on element with xpath "//mat-panel-title[contains(text(),'001 Alex API Test Quiz')]"
    Then I click on element with xpath "//*[contains(text(),'001 Alex API Test Quiz')]//following::button[2]"
    And I wait for element with xpath "//input[@placeholder='Title Of The Quiz *']" to be present
    Then I click on element with xpath "//*[contains(text(),'What is your name?')]"
    And I wait for 1 sec
    Then I click on element with xpath "(//*[contains(text(),'What is your name?')]//following::*[contains(text(), 'Add Option')])[1]"
    And I wait for 1 sec
    Then I type "Don" into element with xpath "(//*[contains(text(),'What is your name?')]//following::*[@placeholder='Option 3*'])[1]"
    And I click on element with xpath "//button/span[contains(text(),'Save')]"
    And I wait for element with xpath "//h4[text()='List of Quizzes']" to be present