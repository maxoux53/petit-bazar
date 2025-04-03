package model;

public class Supplier {
    private Integer vatNumber;
    private String name;
    private String email;
    private Integer phone;
    private String countryName;

    public Supplier(Integer vatNumber, String name, String email, Integer phone, String countryName) {
        this.vatNumber = vatNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.countryName = countryName;
    }
}
