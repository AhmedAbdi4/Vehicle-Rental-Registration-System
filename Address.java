package com.AhmedAbdi

public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address()
    {
        setStreet(null);
        setCity(null);
        setState(null);
        setZipCode(null);
    }
    public Address(String s, String c, String st, String z)
    {
        setStreet(s);
        setCity(c);
        setState(st);
        setZipCode(z);
    }

    public void setStreet(String s)
    {
        street = s;
    }
    public void setCity(String c)
    {
        city = c;
    }
    public void setState(String st)
    {
        state = st;
    }
    public void setZipCode(String z)
    {
        zipCode = z;
    }

    public String getStreet()
    {
        return street;
    }
    public String getCity()
    {
        return city;
    }
    public String getState()
    {
        return state;
    }
    public String getZipCode()
    {
        return zipCode;
    }

    public String toString()
    {
        return( "Street" + street +  "City" + city + "State" + state + "Zip Code" + zipCode );
    }
}
