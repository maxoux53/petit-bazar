package model;

import java.time.LocalDate;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private byte[] password;
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

    public Employee(String firstName, String lastName, byte[] password, Boolean isActive, String street, Integer streetNumber, Integer unitNumber, String roleLabel, LocalDate hireDate, Integer managerId, Integer cityZipCode, String cityName) {
        this(null); // useless, tho might be useful in the future (for the sake of point the modification unique)
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isActive = isActive;
        this.street = street;
        this.streetNumber = streetNumber;
        this.unitNumber = unitNumber;
        this.roleLabel = roleLabel;
        this.hireDate = hireDate;
        this.managerId = managerId;
        this.cityZipCode = cityZipCode;
        this.cityName = cityName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setCityZipCode(int cityZipCode) {
        this.cityZipCode = cityZipCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public Boolean getActive() {
        return isActive;
    }

    public String getStreet() {
        return street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public String getRoleLabel() {
        return roleLabel;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public Integer getCityZipCode() {
        return cityZipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getId() {
        return id;
    }
}
