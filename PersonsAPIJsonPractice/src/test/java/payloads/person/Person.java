package payloads.person;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private Address address;
    private List<Contacts> contacts;

    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }

    public Address getAddress()
    {
        return this.address;
    }

    public List<Contacts> getContacts()
    {
        return this.contacts;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public void setAge(int age)
    {
        this.age=age;
    }

    public void setAddress(Address address)
    {
        this.address=address;
    }
public void setContacts(List<Contacts> contacts)
{
    this.contacts=contacts;

}







}
