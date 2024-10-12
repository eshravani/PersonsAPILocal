package payloads.employees;

public class Employment {
    private String status;
    private String startDate;
    private String endDate;


    public String getStatus()
    {
       return this.status;
    }

    public String getStartDate()
    {
        return this.startDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
