package api;

import org.testng.annotations.Test;
import runtests.ApiSpecs;
import source.Constants;
import source.UserRegisterData;
import static api.CreateNewUserTest.getUserId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserTest {

    @Test
    public void updateUserName() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
                given()
                .header("Authorization", "Bearer " + PredefinedDataTest.getToken())
                .body(new UserRegisterData("New name for John Snow"))
                .when()
                .put("/users/change-name/" + getUserId())
                .then()
                .body("message", equalTo("User name was updated"));
    }
}
