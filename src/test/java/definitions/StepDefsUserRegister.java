package definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import source.Constants;
import source.User;
import source.SqlQueriesJdbc;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static source.TestEnvironmentConfig.getDriver;

public class StepDefsUserRegister {
    private int userID;
    private String activationCode;
    private String uniqueAutoGenEmail;

    @Then("I retrieve data from the Database for user with email {string}")
    public void iRetrieveDataFromDbForUserWithEmail(String email) throws SQLException {
        if (email.equals("auto-generated")) {
            email = uniqueAutoGenEmail;
        }
        String result = SqlQueriesJdbc.getIdAndActivationCode(email);
        String[] resultSet = result.split(";");
        userID = Integer.parseInt(resultSet[0]);
        activationCode = resultSet[1];

        System.out.println("User ID: " + userID);
        System.out.println("Activation Code: " + activationCode);
    }

    @Then("I activate the user")
    public void iActivateTheUser() throws IOException {
        User.activateUser(userID, activationCode);
    }

    @And("I type {string} into the input field {string}")
    public void iTypeIntoTheInputField(String data, String element) {
        WebDriver driver = getDriver();
        switch (element) {
            case "First Name":
                driver.findElement(By.xpath(Constants.FIELD_FIRSTNAME_XPATH)).sendKeys(data);
                break;
            case "Last Name":
                driver.findElement(By.xpath(Constants.FIELD_LASTNAME_XPATH)).sendKeys(data);
                break;
            case "Email":
                if (data.equals("auto-generated")) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddHHmmss");
                    LocalDateTime now = LocalDateTime.now();
                    data = "autogen"+dtf.format(now)+"@email.com";
                    uniqueAutoGenEmail = data;
                }
                driver.findElement(By.xpath(Constants.FIELD_EMAIL_XPATH)).sendKeys(data);
                break;
            case "Group Code":
                driver.findElement(By.xpath(Constants.FIELD_GROUP_ID_XPATH)).sendKeys(data);
                break;
            case "Password":
                driver.findElement(By.xpath(Constants.FIELD_PASSWORD_XPATH)).sendKeys(data);
                break;
            case "Confirm Password":
                driver.findElement(By.xpath(Constants.FIELD_CONFIRM_PASSWORD_XPATH)).sendKeys(data);
                break;
        }
    }

    @Then("I click on the button {string}")
    public void iClickOnButton(String element) {
        WebDriver driver = getDriver();
        switch (element) {
            case "Register Me":
                driver.findElement(By.xpath(Constants.BUTTON_REGISTER_ME_XPATH)).click();
        }
    }
}
