package modelPackage;

import java.util.Date;

public class Customer {
    private String id;
    private int loyaltyCardNumber;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String phone;
    private int loyaltyPoints;

    // CONSTRUCTOR

    public Customer() {}

    // GETTER

    public String getId() {
        return id;
    }

    public int getLoyaltyCardNumber() {
        return loyaltyCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // SETTER


    public void setId(String id) {
        this.id = id;
    }

    public void setLoyaltyCardNumber(int loyaltyCardNumber) {
        this.loyaltyCardNumber = loyaltyCardNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
