package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloadBuilder.RequestBody;
import requestBuilder.Requests;

public class UserDetails {
    Response response;

    @Test
    public void retrieveDataTest() {

        response = Requests.getUserDetailsRequest();
        response.then().statusCode(200);
        int statusCode = response.getStatusCode();
        String firstName = response.jsonPath().getString("data.first_name");
        String url = response.jsonPath().getString("support.url");
        System.out.println("Status Code: " + statusCode);
        System.out.println("First Name: " + firstName);
        System.out.println("Support URL: " + url);


    }

    @Test
    public void updateEmailAddressTest() {
        Requests.updateEmailRequest("snkwanyana@gmail.com").then().statusCode(200);

    }

    @Test
    public void deleteLastnameTest() {
        Requests.deleteLastnameRequest("").then().statusCode(200);
    }


}
