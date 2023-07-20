package api;

import org.testng.annotations.BeforeTest;
import runtests.ApiSpecs;
import source.Constants;
import source.Role;
import source.SingleUserData;
import java.util.List;
import static io.restassured.RestAssured.given;

public class PredefinedDataTest {
    private static String token;
    private static String studentToken;
    private static List<SingleUserData> listOfAllUsers;

    public static List<SingleUserData> getList() {
        return listOfAllUsers;
    }

    public static String getToken() {
        return token;
    }

    public static String getStudentToken() {
        return studentToken;
    }

    @BeforeTest
    public static void generateTeachersToken() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
        token = given()
                .body(new Role("TEACHER"))
                .when()
                .post("/sign-in")
                .then()
                .extract().body().jsonPath().getString("token");
    }

    @BeforeTest
    public static void generateStudentToken() {
        ApiSpecs.setSpecs(ApiSpecs.request(Constants.URL_API), ApiSpecs.response(200));
        studentToken = given()
                .body(new Role("STUDENT"))
                .when()
                .post("/sign-in")
                .then()
                .extract().body().jsonPath().getString("token");
    }

    @BeforeTest(dependsOnMethods = {"generateTeachersToken"})
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