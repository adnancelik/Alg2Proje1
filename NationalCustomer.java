package Test;

public class NationalCustomer extends Customer {

    private int licanceplatenumber;//il trafik plaka kodu

    public int getLicancePlateNumber() {
        return this.licanceplatenumber;
    }

    public void setLicancePlateNumber(int licanceplatenumber) {
        this.licanceplatenumber = licanceplatenumber;
    }

    private String occupation;//mesleği

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public NationalCustomer() {

    }

    public NationalCustomer(int customerid, String name, String surname, int licanceplatenumber, String occupation) {
        super(customerid, name, surname);
        this.licanceplatenumber = licanceplatenumber;
        this.occupation = occupation;
    }

    /*
    // copy Constructor eksik. ne olduğunu anlaşılınca yazılacak.
    public NationalCustomer(NationalCustomer nationalcustomer) {//copy constructor
        super(nationalcustomer.getCustomerID(), nationalcustomer.getName(), nationalcustomer.getSurname());
        this.licanceplatenumber = nationalcustomer.licanceplatenumber;
        this.occupation = nationalcustomer.occupation;
    }
     */
    public NationalCustomer(NationalCustomer customer) {//copy constructor
        super(customer.getCustomerID(), customer.getName(), customer.getSurname());
        this.licanceplatenumber = customer.licanceplatenumber;
        this.occupation = customer.occupation;

    }

    @Override
    public String toString() {
        return String.valueOf(super.getCustomerID()) + " " + super.getName() + " " + super.getSurname() + " "
                + String.valueOf(this.licanceplatenumber) + " " + this.occupation;
    }
}
