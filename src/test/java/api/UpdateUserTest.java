package api;

import org.testng.annotations.Test;
import runtests.ApiSpecs;
import source.Constants;
import java.util.HashMap;
import java.util.Map;
import static api.CreateNewUserTest.getUserId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserTest {

    @Test
    public void updateUserName() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
        Map<String, String> newName = new HashMap<>();
        newName.put("name", "New name for John Snow");
                given()
                .header("Authorization", "Bearer " + PredefinedDataTest.getToken())
                .body(newName)
                .when()
                .put("/users/change-name/" + getUserId())
                .then().log().all()
                .body("message", equalTo("User name was updated"));
    }
}
