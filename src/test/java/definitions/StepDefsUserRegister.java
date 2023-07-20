package definitions;

import api.PredefinedDataTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import runtests.ApiSpecs;
import source.Constants;
import source.SqlQueriesJdbc;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static source.Constants.URL_API;
import static source.TestEnvironmentConfig.getDriver;

public class StepDefsUserRegister {
    private String uniqueAutoGenEmail;
    private Integer userId;

    @Then("I activate the user with email {string}")
    public void iActivateTheUser(String email) throws IOException, SQLException {
        int responseCode;
        if (email.equals("auto-generated")) {
            email = uniqueAutoGenEmail;
        }
        String[] resultSet = SqlQueriesJdbc.getIdAndActivationCodeFromDataBase(email).split(";");
        userId = Integer.parseInt(resultSet[0]);
        URL url = new URL(URL_API + "/activate" + "/" + userId + "/" + resultSet[1]);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        responseCode = connection.getResponseCode();
        assertEquals(HttpURLConnection.HTTP_OK, responseCode);
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
                    Random rand = new Random();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddHHmmss");
                    LocalDateTime now = LocalDateTime.now();
                    data = "autogen" + rand.nextInt(99) + dtf.format(now) + "@email.com";
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
            default:
                System.out.println("\nTHE ERROR: Wrong element \""+element+"\", double check element name in the cucumber step!\n");
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

    @And("I delete just registered user")
    public void deleteTheUser() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
        PredefinedDataTest.getTeachersToken();
        given()
                .header("Authorization", "Bearer " + PredefinedDataTest.getToken())
                .when()
                .delete("/users/" + userId)
                .then()
                .body("message", equalTo("User was deleted"));
    }
}
