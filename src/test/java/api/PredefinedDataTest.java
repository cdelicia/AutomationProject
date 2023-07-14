package api;

import org.testng.annotations.BeforeTest;
import runtests.ApiSpecs;
import source.Constants;
import source.SingleUserData;
import source.Teacher;
import java.util.List;
import static io.restassured.RestAssured.given;

public class PredefinedDataTest {
    private static String token;
    private static List<SingleUserData> listOfAllUsers;

    public static List<SingleUserData> getList() {
        return listOfAllUsers;
    }

    public static String getToken() {
        return token;
    }

    @BeforeTest
    public void getTeachersToken() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
        token = given()
                .body(new Teacher())
                .when()
                .post("/sign-in")
                .then()
                .extract().body().jsonPath().getString("token");
    }

    @BeforeTest(dependsOnMethods = {"getTeachersToken"})
    public void getListOfAllUsers() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
        listOfAllUsers = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/users")
                .then()
                .extract().body().jsonPath().getList("", SingleUserData.class);
    }
}