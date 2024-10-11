package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PersonsResources extends EndPoints {
    Response response;

    public Response getPersonsDetails()
    {
        response=given().contentType("application/json")
                .when()
                .get(getPersonsResource);
        return response;
    }}
