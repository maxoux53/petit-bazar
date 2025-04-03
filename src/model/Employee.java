package model;

import java.time.LocalDate;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private byte[] password; // type et fonctionnement à vérifier
    private Boolean isActive;
    private String street;
    private Integer streetNumber;
    private Integer unitNumber;
    private String roleLabel;
    private LocalDate hireDate;
    private Integer managerId;
    private Integer cityZipCode;
    private String cityName;

    public Employee(Integer id, String firstName, String lastName, byte[] password, Boolean isActive, String street, Integer streetNumber, Integer unitNumber, String roleLabel, LocalDate hireDate, Integer managerId, Integer cityZipCode, String cityName) {
        this.id = id;
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
}
