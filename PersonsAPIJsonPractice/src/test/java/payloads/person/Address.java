package payloads.person;

public class Address {
    private String city;
    private String street;
    private String zipcode;

    public String getCity()
    {
       return this.city;

    }

    public String getStreet()
    {
        return this.street;
    }

    public String getZipcode()
    {
        return this.zipcode;
    }

    public void setCity(String city)
    {
        this.city=city;

    }
    public void setStreet(String street)
    {
        this.street=street;
    }
    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }




}
