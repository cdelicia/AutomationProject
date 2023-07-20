package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import source.Constants;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CreateQuizTest {
    private static int quizId;
    private JSONObject jsonObject;

    public static int getQuizId() {
        return quizId;
    }

    @BeforeClass
    public void setBodyPropertiesForRequest() {
        List<JSONObject> array = new ArrayList<>();
        jsonObject = new JSONObject();
        jsonObject.put("name", "API QUIZ");
        jsonObject.put("totalScore", 13);
        jsonObject.put("passingPercentage", 100);

        JSONObject questionProperty = new JSONObject();
        questionProperty.put("type", "TEXTUAL");
        questionProperty.put("question", "Why in the world?");
        questionProperty.put("score", 5);

        array.add(questionProperty);
        jsonObject.put("questions", array);
    }

    @Test
    public void createQuizTest() {
        PredefinedDataTest.getTeachersToken();
        Response response = given()
                .header("Authorization", "Bearer " + PredefinedDataTest.getToken())
                .body(jsonObject.toString())
                .when()
                .post(Constants.URL_API + "/quiz")
                .then()
                .statusCode(200)
                .body("createdAt", notNullValue())
                .extract().response();
        JsonPath responseJson = response.jsonPath();
        quizId = Integer.parseInt(responseJson.getString("id"));
        Assert.assertTrue(quizId > 0);
    }
}
