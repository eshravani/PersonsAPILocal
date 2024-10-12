package tests;

import endpoints.ProductsResources;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Products extends ProductsResources {

    @Test
    public void getProductId()
    {
        Response res=getProducts();

        JSONObject jo=new JSONObject(res.asString());
        JSONArray ja = jo.getJSONArray("products");
        for(int i=0;i<ja.length();i++)
        {
            JSONObject jo1=ja.getJSONObject(i);
            if(jo1.getString("ProductCategory").equals("Web Apps"))
            {
                JSONObject jo2=jo1.getJSONObject("productDetails");
                if(jo2.getJSONObject("productInfo").get("productName").equals("Candy"))
                {
                    System.out.println(jo2.getInt("productId"));
                }
            }
        }


    }}
