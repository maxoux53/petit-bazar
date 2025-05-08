package model;

public class City implements EmployeeInfoWrapper {
    private Integer zipCode;
    private String name;
    private String country;

    public City(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public City(Integer zipCode, String name, String country) {
        this.zipCode = zipCode;
        this.name = name;
        this.country = country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
