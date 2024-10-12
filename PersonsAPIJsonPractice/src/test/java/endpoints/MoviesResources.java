package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MoviesResources extends EndPoints{
    Response response;

    public Response getMoviesDetails()
    {
        response=given().contentType("application/json")
                .when()
                .get(moviesResource);
        return response;
    }}

