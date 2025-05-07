package modelPackage;

import java.time.LocalDate;

public class Customer {
    private String id;
    private int loyaltyCardNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private int loyaltyPoints;

    // CONSTRUCTOR

    public Customer() {}

    // GETTER

    public int getLoyaltyCardNumber() {
        return loyaltyCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
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

    public void setLoyaltyCardNumber(int loyaltyCardNumber) {
        this.loyaltyCardNumber = loyaltyCardNumber;
    }

    public void setBirthDate(LocalDate birthDate) {
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
