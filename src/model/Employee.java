package model;

import java.time.LocalDate;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private Byte[] password; // check type (primitive/referenced)
    private Boolean isActive;
    private String street;
    private Integer streetNumber;
    private Integer unitNumber;
    private String roleLabel;
    private LocalDate hireDate;
    private Integer managerId;
    private Integer cityZipCode;
    private String cityName;

    public Employee(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(Byte[] password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public void setCityZipCode(Integer cityZipCode) {
        this.cityZipCode = cityZipCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
