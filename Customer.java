package proje1_05140010136;

public class Customer {

    private int customerID;

    public int getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String surname;

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Customer() {

    }

    public Customer(int customerID, String name, String surname) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        /*
        setCustomerID(customerID);
        setName(name);
        setSurname(surname);*/
    }
// copy constructor metodu eksik. ne olduğunu anlamadım.

    public Customer(Customer customer) {//copy constructor
        this.customerID = customer.customerID;
        this.name = customer.name;
        this.surname = customer.surname;
    }

    @Override
    public String toString() {
        return customerID + " " + name + " " + surname;
    }

}
