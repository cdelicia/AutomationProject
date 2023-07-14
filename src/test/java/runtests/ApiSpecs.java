package runtests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiSpecs {

    public static RequestSpecification request(String uri) {
        return new RequestSpecBuilder().setBaseUri(uri).setContentType(ContentType.JSON).build();
    }

    public static ResponseSpecification response(int code) {
        return new ResponseSpecBuilder().expectStatusCode(code).build();
    }

    public static void setSpecs(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
