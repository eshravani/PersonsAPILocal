package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class EcommerceProductCatalogResouces extends EndPoints{

    Response res;
    public Response getProducts()
    {
        res=given().contentType("application/json").get(eCommerceProductCatalog);
        return res;

    }}
