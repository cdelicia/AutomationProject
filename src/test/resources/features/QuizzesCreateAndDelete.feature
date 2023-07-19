@smoke
Feature: Create a quiz and then Delete the quiz


  Background:
    Given I open "Login" page
    And I should see page title contains "Assessment Control"
    Then I sign in as a "Diana Brown"
    And I wait for element with xpath "//header/div" to be present
    And element with xpath "//header/div/h3" should contain text "Diana Brown"


  Scenario: Quiz creation
    Then I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    Then I wait for element with xpath "//h4[contains(text(),'List of Quizzes')]" to be present
    And I click on element with xpath "//span[contains(text(),'Create New Quiz')]"
    And I wait for 1 sec
    Then I type "0001 AnnaQuiz 0510 D" into element with xpath "//input[@formcontrolname='name']"
    Then I click on element with xpath " //mat-icon[contains(text(),'add_circle')]"
    Then I click on element with xpath "//mat-radio-button[2]"
    And I wait for 1 sec
    Then I type "Single choice question example" into element with xpath "//textarea[@formcontrolname='question']"
    Then I type "Correct answer" into element with xpath "//textarea[@placeholder='Option 1*']"
    Then I type "Incorrect answer" into element with xpath "//textarea[@placeholder='Option 2*']"
    And I click on element with xpath "(//mat-radio-button[@class='mat-radio-button mat-accent'])[1]"
    And I click on element with xpath " //span[contains(text(),'Save')]"
    Then I wait for element with xpath "//h4[contains(text(),'List of Quizzes')]" to be present
    And The element with xpath "//mat-panel-title[contains(text(),'0001 AnnaQuiz 0510 D')]" should be presented


  Scenario: Delete the quiz
    Then I click on element with xpath "//h5[contains(text(),'Quizzes')]"
    And I wait for element with xpath "//h4[contains(text(),'List of Quizzes')]" to be present
    Then I click on element with xpath "//mat-panel-title[contains(text(),'0001 AnnaQuiz 0510 D')]"
    Then I click on element with xpath "(//*[contains(text(), '0001 AnnaQuiz 0510 D')]//ancestor::mat-expansion-panel//button)[3]"
    And I wait for 1 sec
    Then I click on element with xpath "//div[@class='mat-dialog-actions']//span[contains(text(),'Delete')]"
    And I wait for 1 sec
    And The element with xpath "//mat-panel-title[contains(text(),'0001 AnnaQuiz 0510 D')]" should not be presented
