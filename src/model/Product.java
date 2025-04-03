package model;

public class Product {
    private Integer barcode;
    private String name;
    private String description;
    private Integer amount;
    private Boolean isAvailable;
    private Character vatType;
    private Integer categoryId;
    private Integer brandId;
    private Integer supplierVatNumber;

    public Product(Integer barcode, String name, String description, Integer amount, Boolean isAvailable, Character vatType, Integer categoryId, Integer brandId, Integer supplierVatNumber) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.vatType = vatType;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.supplierVatNumber = supplierVatNumber;
    }
}
