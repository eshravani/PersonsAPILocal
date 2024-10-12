package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import endpoints.EmployeesResource;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.employees.EmployeesPojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Employees extends EmployeesResource {
    /*
    Validation Scenarios:
Check Employment Status: Validate that the employment status is either "full-time" or "part-time."
Validate Skills: Ensure that the skills array is not empty.
Check Employment Dates: Validate that the end date (if present) is after the start date.
     */
    private List<EmployeesPojo> employees;

    @Test
    public void checkEmploymentStatus() throws JsonProcessingException {
        /*
        objectMapper.readValue(...):
readValue() is a method of ObjectMapper that reads JSON and converts it into the specified Java object.
new TypeReference<>() {}:
This specifies the target type for deserialization, which is List<EmployeesPojo>.
TypeReference helps Jackson understand the target type when dealing with complex types, like lists or maps. Here, it tells Jackson to convert the JSON string into a List of EmployeesPojo objects.
         */
        ObjectMapper objectMapper = new ObjectMapper();
        employees = objectMapper.readValue(getEmployeeDetails().asString(), new TypeReference<>() {
        });
        int size = employees.size();
        for (int i = 0; i < size; i++) {
            if (employees.get(i).getEmployment().getStatus().equalsIgnoreCase("full-time")) {
                System.out.println(employees.get(i).getName() + " is full time employee");
            }
        }
    }

    @Test
    public void validateSkills() throws JsonProcessingException {
        getEmployeeDetails().then().log().all();
        ObjectMapper om = new ObjectMapper();
        employees = om.readValue(getEmployeeDetails().asString(), new TypeReference<>() {
        });
        int size = employees.size();
        for (int i = 0; i < size; i++) {
            // if(employees.get(i).getSkills().size()>0)
            Assert.assertTrue((employees.get(i).getSkills().size() > 0), employees.get(i).getName() + " is not having atleast a single skills");

        }
    }

    @Test
    public void checkEndDateIsGreaterThanStartDate() throws ParseException {
        JSONArray employees = new JSONArray(getEmployeeDetails().asString());
        int size = employees.length();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < size; i++) {
            JSONObject employeeDetails = employees.getJSONObject(i).getJSONObject("employment");
            String endDate = employeeDetails.optString("endDate", null); //handles the potential nulls
            String startDate = employeeDetails.getString("startDate");
            if (endDate != null && !endDate.isEmpty()) {
                Date endD = formatter.parse(endDate);
                Date startD = formatter.parse(startDate);
                Assert.assertTrue(endD.after(startD), "employee end date is prior to start date");

            }
        }
    }
}