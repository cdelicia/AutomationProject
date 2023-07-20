package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import runtests.ApiSpecs;
import source.Constants;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import source.SqlQueriesJdbc;
import source.UserRegisterData;
import java.sql.SQLException;

public class CreateNewUserTest {
    private static final UserRegisterData newUser = new UserRegisterData();
    private static Integer userId;
    private String activationCode;

    public static Integer getUserId() {
        return userId;
    }

    @Test (groups = {"createNewUserTest"})
    public void createNewUserTest() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
        Response response = given()
                .body(newUser)
                .when()
                .post("/sign-up")
                .then()
                .body("message", equalTo("User was created"))
                .extract().response();
        JsonPath responseJson = response.jsonPath();
        Assert.assertEquals(responseJson.getString("status"), "success");
    }

    @AfterClass
    public void activateUser() throws SQLException {
        String[] resultSet = SqlQueriesJdbc.getIdAndActivationCodeFromDataBase(newUser.email).split(";");
        userId = Integer.parseInt(resultSet[0]);
        activationCode = resultSet[1];
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
        given()
                .when()
                .get("/activate/" + userId + "/" + activationCode)
                .then()
                .body("message", equalTo("User was activated"));
    }
}
