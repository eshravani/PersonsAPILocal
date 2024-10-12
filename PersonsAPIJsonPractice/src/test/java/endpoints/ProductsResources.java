package endpoints;

import io.restassured.response.Response;

import java.lang.annotation.Retention;

import static io.restassured.RestAssured.given;

public class ProductsResources extends EndPoints {
    Response res;
    public Response getProducts(){
      res=  given().contentType("application/json")
                .get(productsResource);
        return res;

    }
}
