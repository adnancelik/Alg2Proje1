package proje1_05140010136;

public class InternationalCustomer extends Customer {

    private String country;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String city;

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public InternationalCustomer() {

    }

    public InternationalCustomer(int customerid, String name, String surname, String country, String city) {
        super(customerid, name, surname);
        this.country = country;
        this.city = city;
    }

    /*
    // copy constructor ne olduğunu öğrenince hazırlanacak.
    public InternationalCustomer(InternationalCustomer internationalcustomer) {//copy constructor
        super(internationalcustomer.getCustomerID(), internationalcustomer.getName(), internationalcustomer.getSurname());
        this.city = internationalcustomer.city;
        this.country = internationalcustomer.country;
    }
     */
    public InternationalCustomer(InternationalCustomer customer) {//copy constructor
        super(customer.getCustomerID(), customer.getName(), customer.getSurname());
        this.country = customer.country;
        this.city = customer.city;
    }

    @Override
    public String toString() {
        return String.valueOf(super.getCustomerID()) + " "
                + super.getName() + " "
                + super.getSurname() + " "
                + this.country + " "
                + this.city;
    }
}
