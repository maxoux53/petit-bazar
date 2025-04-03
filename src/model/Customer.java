package model;

import java.time.LocalDate;

public class Customer {
    private Integer loyaltyCardNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private Integer phone;
    private Integer vatNumber;
    private Integer loyaltyPoints;

    public Customer(Integer loyaltyCardNumber, String firstName, String lastName, LocalDate birthDate, String email, Integer phone, Integer vatNumber, Integer loyaltyPoints) {
        this.loyaltyCardNumber = loyaltyCardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.vatNumber = vatNumber;
        this.loyaltyPoints = loyaltyPoints;
    }
}
