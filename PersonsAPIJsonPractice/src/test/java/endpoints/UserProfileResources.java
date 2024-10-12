package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserProfileResources extends EndPoints {
    Response response;

    public Response getUserProfile() {
        response = given().contentType("application/json").get(userProfile);
        return response;
    }
}
