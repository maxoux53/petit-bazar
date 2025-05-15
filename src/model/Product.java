package model;

import exceptions.ProhibitedValueException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private Long barcode;
    private String name;
    private String description;
    private Integer amount;
    private Boolean isAvailable;
    private Character vatType;
    private Integer categoryId;
    private Integer brandId;
    private BigDecimal exclVatPrice;
    private LocalDate startDate;

    public Product(Long barcode, String name, String description, Integer amount, Boolean isAvailable, Character vatType, Integer categoryId, Integer brandId, BigDecimal exclVatPrice, LocalDate startDate) throws ProhibitedValueException {
        this.barcode = barcode;
        setName(name);
        setDescription(description);
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.vatType = vatType;
        this.categoryId = categoryId;
        this.brandId = brandId;
        setExclVatPrice(exclVatPrice);
        this.startDate = startDate;
    }

    public Product(String name, String description, Integer amount, Boolean isAvailable, Character vatType, Integer categoryId, Integer brandId, BigDecimal exclVatPrice, LocalDate startDate) throws ProhibitedValueException {
        this(null, name, description, amount, isAvailable, vatType, categoryId, brandId, exclVatPrice, startDate);
    }

    public Product(Long barcode, String name, Integer amount, Boolean isAvailable, Character vatType, Integer categoryId, Integer brandId, BigDecimal exclVatPrice, LocalDate startDate) throws ProhibitedValueException {
        this(barcode, name, null, amount, isAvailable, vatType, categoryId, brandId, exclVatPrice, startDate);
    }

    public Product(Long barcode) throws ProhibitedValueException {
        this(barcode, null, null, null, null, null, null, null, null, null);
    }

    // Setters
    public void setName(String name) throws ProhibitedValueException {
        if (name.length() > 60) {
            throw new ProhibitedValueException("Le nom du produit ne peut pas dépasser 60 caractères");
        }

        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExclVatPrice(BigDecimal exclVatPrice) throws ProhibitedValueException {
        if (exclVatPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProhibitedValueException("Le prix hors TVA doit être supérieur à 0");
        }

        this.exclVatPrice = exclVatPrice;
    }

    // Getters
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

    public BigDecimal getExclVatPrice() {
        return exclVatPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Long getBarcode() {
        return barcode;
    }
}
