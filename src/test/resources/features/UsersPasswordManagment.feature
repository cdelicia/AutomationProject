@smoke
Feature: Password field tests: boundary, valid/invalid, change password


  Background:
    Given I open "Login" page
    Then I sign in as a "Alex Student"
    Then I wait for element with xpath "//header/div" to be present
    Then element with xpath "//header/div/h3" should contain text "Alex Student"


  Scenario: Student: Settings - Password. The user is able to change password with valid credentials
    Then I click on element with xpath "//h5[contains(text(),'Settings')]"
    Then I wait for element with xpath "//h4[contains(text(),'Settings')]" to be present
    And I click on element with xpath "//span[contains(text(),'Change Your Password')]"
    And I wait for 1 sec
    Then I type "12345ABc" into element with xpath "//input[@formcontrolname='password']"
    Then I type "12345ABC" into element with xpath "//input[@formcontrolname='newPassword']"
    Then I type "12345ABC" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I click on element with xpath "//form//span[contains(text(), 'Change')]"
    Then I click on element with xpath "//h5[contains(text(),'Settings')]"
    And I wait for 1 sec
    Then I wait for element with xpath "//h4[contains(text(),'Settings')]" to be present
    And I click on element with xpath "//span[contains(text(),'Change Your Password')]"
    And I wait for 1 sec
    Then I type "12345ABC" into element with xpath "//input[@formcontrolname='password']"
    Then I type "12345ABc" into element with xpath "//input[@formcontrolname='newPassword']"
    Then I type "12345ABc" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I click on element with xpath "//form//span[contains(text(), 'Change')]"


  Scenario: Student: Settings - Password. The user cannot change password if new passwords do not match
    Then I click on element with xpath "//h5[contains(text(),'Settings')]"
    Then I wait for element with xpath "//h4[contains(text(),'Settings')]" to be present
    And I click on element with xpath "//span[contains(text(),'Change Your Password')]"
    And I wait for 1 sec
    Then I type "12345ABc" into element with xpath "//input[@formcontrolname='password']"
    Then I type "12345ABC" into element with xpath "//input[@formcontrolname='newPassword']"
    Then I type "12345ABCD" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I click on element with xpath "//form//span[contains(text(), 'Change')]"
    And I wait for 1 sec
    Then The element with xpath "//mat-error[contains(text(),'Entered passwords should match')]" should be presented


  Scenario: Student: Settings - Password. The user cannot change the password if new password contains less then 5 characters
    Then I click on element with xpath "//h5[contains(text(),'Settings')]"
    Then I wait for element with xpath "//h4[contains(text(),'Settings')]" to be present
    And I click on element with xpath "//span[contains(text(),'Change Your Password')]"
    And I wait for 1 sec
    Then I type "12345ABc" into element with xpath "//input[@formcontrolname='password']"
    Then I type "12345" into element with xpath "//input[@formcontrolname='newPassword']"
    Then I type "1234" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I click on element with xpath "//form//span[contains(text(), 'Change')]"
    And I wait for 1 sec
    Then The element with xpath "//mat-error[contains(text(),'Too short. Should be at least 5 to 32 characters')]" should be presented


  Scenario: Student: Settings - Password. The user cannot change the password if new password contains more then 32 characters
    Then I click on element with xpath "//h5[contains(text(),'Settings')]"
    Then I wait for element with xpath "//h4[contains(text(),'Settings')]" to be present
    And I click on element with xpath "//span[contains(text(),'Change Your Password')]"
    And I wait for 1 sec
    Then I type "12345ABc" into element with xpath "//input[@formcontrolname='password']"
    Then I type "12345678901234567890123456789012" into element with xpath "//input[@formcontrolname='newPassword']"
    Then I type "123456789012345678901234567890123" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I click on element with xpath "//form//span[contains(text(), 'Change')]"
    And I wait for 1 sec
    Then The element with xpath "//mat-error[contains(text(),'Too long. Should be at least 5 to 32 characters')]" should be presented


  Scenario: Student: Settings - Password. The user can change the password if the password contains all type of data
    Then I click on element with xpath "//h5[contains(text(),'Settings')]"
    Then I wait for element with xpath "//h4[contains(text(),'Settings')]" to be present
    And I click on element with xpath "//span[contains(text(),'Change Your Password')]"
    And I wait for 1 sec
    Then I type "12345ABc" into element with xpath "//input[@formcontrolname='password']"
    Then I type "12345ABc$" into element with xpath "//input[@formcontrolname='newPassword']"
    Then I type "12345ABc$" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I click on element with xpath "//form//span[contains(text(), 'Change')]"
    Then I click on element with xpath "//h5[contains(text(),'Settings')]"
    And I wait for 1 sec
    Then I wait for element with xpath "//h4[contains(text(),'Settings')]" to be present
    And I click on element with xpath "//span[contains(text(),'Change Your Password')]"
    And I wait for 1 sec
    Then I type "12345ABc$" into element with xpath "//input[@formcontrolname='password']"
    Then I type "12345ABc" into element with xpath "//input[@formcontrolname='newPassword']"
    Then I type "12345ABc" into element with xpath "//input[@formcontrolname='confirmPassword']"
    And I click on element with xpath "//form//span[contains(text(), 'Change')]"

