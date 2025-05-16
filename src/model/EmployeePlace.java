package model;

public class EmployeePlace {
    // Attributes
    private String employeeFirstName, employeeLastName, cityName, countryName;
    private Integer cityZipCode;
    
    // Constructors
    public EmployeePlace(String employeeFirstName, String employeeLastName, String cityName, Integer cityZipCode, String countryName) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.cityName = cityName;
        this.cityZipCode = cityZipCode;
        this.countryName = countryName;
    }
    
    // Getters
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getCityZipCode() {
        return cityZipCode;
    }

    public String getCountryName() {
        return countryName;
    }
}
