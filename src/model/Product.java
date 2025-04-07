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

    public Product(Integer barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void setVatType(Character vatType) {
        this.vatType = vatType;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public void setSupplierVatNumber(Integer supplierVatNumber) {
        this.supplierVatNumber = supplierVatNumber;
    }
}
