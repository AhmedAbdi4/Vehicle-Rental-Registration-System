import java.util.ArrayList;


public class Customer {
    private String name;
    private Address address;
    private String creditCardNumber;
    private String phoneNumber;
    private ArrayList<Rental> rentalList;

    public Customer(String name, Address address, String creditCardNumber, String phoneNumber,
                    ArrayList<Rental> rentalList)
    {
        this.name = name;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.phoneNumber = phoneNumber;
        this.rentalList = rentalList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(ArrayList<Rental> rentalList) {
        this.rentalList = rentalList;
    }


    public String toString()
    {
        return "[" + "Customer name=" + name + ", address=" + address + ", creditCardNumber=" + creditCardNumber
                + ", phoneNumber=" + phoneNumber + ", rentalList=" + rentalList + "]";
    }

    public Rental addRental(Rental R)
    {
        return R ;
    }

}