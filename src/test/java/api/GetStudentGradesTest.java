package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import source.Constants;
import java.util.List;
import static io.restassured.RestAssured.given;

public class GetStudentGradesTest {

    @Test
    public void getStudentGrades() {
        Response response = given()
                .header("Authorization", "Bearer " + PredefinedDataTest.getStudentToken())
                .when()
                .get(Constants.URL_API + "/my-grades")
                .then()
                .statusCode(200)
                .extract().response();
        JsonPath responseJson = response.jsonPath();
        List<Integer> userIds = responseJson.get("userId");
        List<String> statuses = responseJson.get("status");
        Assert.assertTrue(userIds.stream().allMatch(id -> id.equals(Constants.CHRIS_STUDENT_USER_ID)));
        Assert.assertTrue(statuses.stream().allMatch(status -> status.equals("GRADED")));
    }
}
