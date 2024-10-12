package payloads.employees;

import java.util.List;

public class EmployeesPojo {

    private int employeeId;
    private String name;
    private String department;
    private List<String> skills;
    private Employment employment;
    private String id;


    public List<String> getSkills()
    {
        return this.skills;

    }

public Employment getEmployment()
{
    return this.employment;

}

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
