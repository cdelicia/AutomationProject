package api;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runtests.ApiSpecs;
import source.Constants;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdateQuizTest {
    private JSONObject jsonObject;

    @BeforeClass
    public void setBodyPropertiesForRequest() {
        List<JSONObject> array = new ArrayList<>();
        jsonObject = new JSONObject();
        jsonObject.put("id", CreateQuizTest.getQuizId());
        jsonObject.put("name", "API QUIZ CHANGED");
        jsonObject.put("totalScore", 21);
        jsonObject.put("passingPercentage", 99);

        JSONObject questionProperty = new JSONObject();
        questionProperty.put("type", "TEXTUAL");
        questionProperty.put("question", "What in the world?");
        questionProperty.put("score", 9);

        array.add(questionProperty);
        jsonObject.put("questions", array);
    }

    @Test
    public void deleteQuizTest() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
                given()
                .header("Authorization", "Bearer " + PredefinedDataTest.getToken())
                .body(jsonObject.toString())
                .when()
                .put("/quiz")
                .then()
                .body("id", equalTo(CreateQuizTest.getQuizId()));
    }
}
