package api;

import org.testng.annotations.Test;
import runtests.ApiSpecs;
import source.Constants;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteQuizTest {
    @Test
    public void deleteQuizTest() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
                given()
                .header("Authorization", "Bearer " + PredefinedDataTest.getToken())
                .when()
                .delete("/quiz/" + CreateQuizTest.getQuizId())
                .then()
                .body("status", equalTo("success"))
                .body("message", equalTo("Quiz was deleted"));
    }
}
