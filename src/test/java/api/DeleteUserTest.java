package api;

import source.Constants;
import org.testng.annotations.Test;
import runtests.ApiSpecs;
import static api.CreateNewUserTest.getUserId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserTest {

    @Test (dependsOnGroups = {"updateNewUserTest"})
    public void deleteUserTest() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
                given()
                .header("Authorization", "Bearer " + PredefinedDataTest.getToken())
                .when()
                .delete("/users/" + getUserId())
                .then()
                .body("message", equalTo("User was deleted"));
    }
}