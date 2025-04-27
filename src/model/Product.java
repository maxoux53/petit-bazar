package model;

import java.time.LocalDate;

public class Product {
    private Integer barcode;
    private String name;
    private String description;
    private Integer amount;
    private Boolean isAvailable;
    private Character vatType;
    private Integer categoryId;
    private Integer brandId;
    private Double exclVatPrice;
    private LocalDate startDate;

    public Product(Integer barcode) {
        this.barcode = barcode;
    }

    public Product(Integer barcode, String name, String description, Integer amount, Boolean isAvailable, Character vatType, Integer categoryId, Integer brandId, Double exclVatPrice, LocalDate startDate) {
        this(barcode);
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.vatType = vatType;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.exclVatPrice = exclVatPrice;
        this.startDate = startDate;
    }

    public Product(String name, String description, Integer amount, Boolean isAvailable, Character vatType, Integer categoryId, Integer brandId, Double exclVatPrice, LocalDate startDate) {
        this(null, name, description, amount, isAvailable, vatType, categoryId, brandId, exclVatPrice, startDate);
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

    public void setExclVatPrice(Double exclVatPrice) {
        this.exclVatPrice = exclVatPrice;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAmount() {
        return amount;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public Character getVatType() {
        return vatType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Double getExclVatPrice() {
        return exclVatPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Integer getBarcode() {
        return barcode;
    }

}
