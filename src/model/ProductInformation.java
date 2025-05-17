package model;

public class ProductInformation {
    // Attributes
    private String productName, categoryName;
    private Integer vatRate;
    
    // Constructors
    public ProductInformation(String productName, String categoryName, Integer vatRate) {
        this.productName = productName;
        this.categoryName = categoryName;
        this.vatRate = vatRate;
    }
    
    // Getters
    public String getProductName() {
        return productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getVatRate() {
        return vatRate;
    }
}
