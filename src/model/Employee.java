package model;

import exceptions.ProhibitedValueException;

import java.time.LocalDate;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private byte[] password;
    private Boolean isActive;
    private String street;
    private String streetNumber;
    private Integer unitNumber;
    private String roleLabel;
    private LocalDate hireDate;
    private Integer managerId;
    private Integer cityZipCode;
    private String cityName;

    public Employee(Integer id, String firstName, String lastName, byte[] password, Boolean isActive, String street, String streetNumber, Integer unitNumber, String roleLabel, LocalDate hireDate, Integer managerId, Integer cityZipCode, String cityName) throws ProhibitedValueException {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        this.password = password;
        this.isActive = isActive;
        setStreet(street);
        setStreetNumber(streetNumber);
        setUnitNumber(unitNumber);
        setRoleLabel(roleLabel);
        this.hireDate = hireDate;
        this.managerId = managerId;
        setCityZipCode(cityZipCode);
        setCityName(cityName);
    }

    public Employee(String firstName, String lastName, byte[] password, Boolean isActive, String street, String streetNumber, Integer unitNumber, String roleLabel, LocalDate hireDate, Integer managerId, Integer cityZipCode, String cityName) throws ProhibitedValueException {
        this(null, firstName, lastName, password, isActive, street, streetNumber, unitNumber, roleLabel, hireDate, managerId, cityZipCode, cityName);
    }

    public Employee(Integer id, String firstName, String lastName, byte[] password, Boolean isActive, String street, String streetNumber, String roleLabel, LocalDate hireDate, Integer cityZipCode, String cityName) throws ProhibitedValueException {
        this(id, firstName, lastName, password, isActive, street, streetNumber, null, roleLabel, hireDate, null, cityZipCode, cityName);
    }

    // Setters
    public void setFirstName(String firstName) throws ProhibitedValueException {
        if (firstName != null && firstName.length() > 20) {
            throw new ProhibitedValueException("Le prénom ne peut pas dépasser 20 caractères");
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws ProhibitedValueException {
        if (lastName != null && lastName.length() > 25) {
            throw new ProhibitedValueException("Le nom ne peut pas dépasser 25 caractères");
        }

        this.lastName = lastName;
    }

    public void setStreet(String street) throws ProhibitedValueException {
        if (street != null && street.length() > 30) {
            throw new ProhibitedValueException("La rue ne peut pas dépasser 30 caractères");
        }

        this.street = street;
    }

    public void setStreetNumber(String streetNumber) throws ProhibitedValueException {
        if (streetNumber != null && streetNumber.length() > 4) {
            throw new ProhibitedValueException("Le numéro de rue ne peut pas dépasser 4 caractères");
        }

        this.streetNumber = streetNumber;
    }

    public void setUnitNumber(Integer unitNumber) throws ProhibitedValueException {
        if (unitNumber != null && unitNumber < 1) {
            throw new ProhibitedValueException("Le numéro de boite postale doit être supérieur ou égal à 1");
        }

        this.unitNumber = unitNumber;
    }

    public void setRoleLabel(String roleLabel) throws ProhibitedValueException {
        if (roleLabel != null && roleLabel.length() > 25) {
            throw new ProhibitedValueException("Le rôle ne peut pas dépasser 25 caractères");
        }

        this.roleLabel = roleLabel;
    }

    public void setCityZipCode(Integer zipCode) throws ProhibitedValueException {
        if (zipCode != null && (zipCode < 1 || zipCode > 99999)) {
            throw new ProhibitedValueException("Le code postal doit être compris entre 1 et 99999");
        }

        this.cityZipCode = zipCode;
    }

    public void setCityName(String name) throws ProhibitedValueException {
        if (name != null && name.length() > 20) {
            throw new ProhibitedValueException("Le nom de la ville ne peut pas dépasser 20 caractères");
        }

        this.cityName = name;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    // Getters
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

    public String getStreetNumber() {
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
