package tests;

import endpoints.UserProfileResources;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfiles extends UserProfileResources {



    @Test
    public void validateEmailFormat()
    {
        Response res=getUserProfile();
        getUserProfile().then().log().all();
        JSONObject userProfile=new JSONObject(res.asString());
        String email=userProfile.getString("email");
        String regEx = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

       // String regEx="^[A-Za-z0-9_-.]+@[A-Za-z.-+_]+\\.[A-Za-z]{2,6}$";
       // if(email.matches(".*@.*.com"))
        if(email.matches(regEx))
        {
            System.out.println(email+" email id is in correct format");
        }
        else
        {
            System.out.println(email+" email id is not in correct format");
        }


    }

    @Test
    public void VerifyEmailNotificationPreferences(){
        Response res=getUserProfile();
        JSONObject userProfile=new JSONObject(res.asString());
        JSONObject notification=userProfile.getJSONObject("preferences").getJSONObject("notifications");
        for(String key: notification.keySet())
        {
            Object value=notification.get(key);
            Assert.assertTrue(value instanceof Boolean,"Invalid value for "+key+" : "+value +"Expected true/false");
        }
        System.out.println("All notification preferences are valid booleans.");
    }


    @Test
    public void verifyCountFriends()
    {
        Response res=getUserProfile();
        JSONObject userProfile=new JSONObject(res.asString());
        JSONArray friends =userProfile.getJSONArray("friends");
        int friendsCount=friends.length();
        Assert.assertTrue(friendsCount>=0," Friends count should be non-negative, but got: " + friendsCount);

    }
}
