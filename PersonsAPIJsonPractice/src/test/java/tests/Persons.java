package tests;

import endpoints.PersonsResources;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.person.Contacts;
import payloads.person.Person;

import java.util.List;


public class Persons extends PersonsResources {
    Response res;
    private static Person person;


    @Test
    public void getPersonDetails() {
        res = getPersonsDetails();
        res.then().statusCode(200);

    }

    @Test
    public void validateEmail() {
        person = getPersonsDetails().as(Person.class);
       List<Contacts> contacts = person.getContacts();
        int size = person.getContacts().size();
        String email = "";
        for (int i = 0; i < contacts.size(); i++) {
            if (person.getContacts().get(i).getType().equals("email")) {
                email = person.getContacts().get(i).getValue();

            }
        }
        Assert.assertEquals(email, "john.doe@example.com");
    }

    @Test
    public void validateEmailWithJsonObjects()
    {
        res  = getPersonsDetails();
        JSONObject jo = new JSONObject(res.asString());
        JSONArray ja = jo.getJSONArray("contacts");
        int size= ja.length();
       String email="";
        for(int i=0;i<size;i++)
        {
            if(ja.getJSONObject(i).getString("type").equals("email"))
            {
                email=ja.getJSONObject(i).getString("value");
            }

        }
        Assert.assertEquals(email,"john.doe@example.com");
    }}