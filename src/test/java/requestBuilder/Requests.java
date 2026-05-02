package requestBuilder;

import common.ReusableData;
import io.restassured.response.Response;

import static common.ReusableData.baseUri;
import static io.restassured.RestAssured.given;

public class Requests {

    public static Response getUserDetailsRequest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .header("x-api-key", ReusableData.x_api_key)
                .log().all()
                .when()
                .get(baseUri + "/api/users/2")
                .then()
                .log().all()
                .extract().response();
        response.getBody().prettyPrint();
        return response;
    }

    public static Response updateEmailRequest(String email) {
        return given()
                .header("Content-Type", "application/json")
                .header("x-api-key", ReusableData.x_api_key)
                .body(payloadBuilder.RequestBody.updateEmail(email).toJSONString())
                .log().all()
                .when()
                .put(baseUri+"/api/users/2")
                .then()
                .log().all()
                .extract().response();
    }

    public static Response deleteLastnameRequest(String lastname) {
        return given()
                .header("Content-Type", "application/json")
                .header("x-api-key", ReusableData.x_api_key)
                .body(payloadBuilder.RequestBody.deleteLastname(lastname).toJSONString())
                .log().all()
                .when()
                .patch(baseUri+"/api/users/2")
                .then()
                .log().all()
                .extract().response();
    }

}
