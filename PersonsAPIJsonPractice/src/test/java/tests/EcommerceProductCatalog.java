package tests;

import endpoints.EcommerceProductCatalogResouces;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceProductCatalog extends EcommerceProductCatalogResouces {


    @Test
    public void validateProductAvailability()
    {
     //   getProducts().then().log().all();
        Response res= getProducts();
        JSONObject jo= new JSONObject(res.asString());
        JSONArray productsArray=jo.getJSONObject("store").getJSONArray("products");
        for(int i=0;i<productsArray.length();i++)
        {
            JSONObject product=productsArray.getJSONObject(i);
           if(product.has("productId")&&product.getBoolean("availability"))
           {
               int productId=product.getInt("productId");
               System.out.println("Available Product ID: " + productId);

            Assert.assertTrue(productId > 0, "Product ID should be positive.");
        } else {
        System.out.println("Product ID " + product.getInt("productId") + " is not available.");
    }
        }

    }

    @Test
    public void checkPriceFormat()

    {
        Response res=getProducts();
        JSONObject store=new JSONObject(res.asString()).getJSONObject("store");
        JSONArray products = store.getJSONArray("products");
        for(int i=0;i<products.length();i++)
        {
            Double price=products.getJSONObject(i).getDouble("price");
            if(String.valueOf(price).matches("\\d+.\\d{2}"))
            {
                System.out.println(price+" price is in correct format");
            }
            else
            {
                System.out.println(price+" price is not in correct format");
            }

        }
    }

    @Test
    public void verifyWarrantyInfoMoreThan2AndGetProductId()
    {
        Response res=getProducts();
        JSONObject store=new JSONObject(res.asString()).getJSONObject("store");
        JSONArray products = store.getJSONArray("products");
        for(int i=0;i<products.length();i++)
        {
            JSONObject product = products.getJSONObject(i);
           String warranty= product.getJSONObject("specifications").getString("warranty");
           String warrArr[]=warranty.split(" ");
           if(Integer.parseInt(warrArr[0])>2&&product.getDouble("price")<1200)
           {
               int productId=product.getInt("productId");
               System.out.println(productId);
           }
        }

    }
}
