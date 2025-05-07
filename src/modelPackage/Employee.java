package modelPackage;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private byte[] password;
    private boolean isActive;
    private String street;
    private int streetNumber;
    private int unitNumber;
    private LocalDate hireDate;
    private String idRole;
    private String idManager;
    private String idCity;

    // CONSTRUCTOR

    public Employee() {}

    // GETTER

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public byte[] getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getIdRole() {
        return idRole;
    }

    public String getIdManager() {
        return idManager;
    }

    public String getIdCity() {
        return idCity;
    }

    // SETTER


    public void setPassword(byte[] password) {
        this.password = password;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }
}
