package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EmployeesResource extends EndPoints{
    Response response;

    public Response getEmployeeDetails()
    {
        response=given().contentType("application/json")
                .when()
                .get(employeeResource);
        return response;
    }}

