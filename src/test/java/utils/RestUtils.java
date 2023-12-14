package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestUtils {

    private static Response response;

    public static Response getResponse() {
        return response;
    }

    public static void post(Object json){
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .log().all()
                .body(json)
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
    }
}
