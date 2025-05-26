package model;

public class SalesInfo {
    private Long productBarcode;
    private String productName;
    private int sumQuantity; // should be primitive?

    public SalesInfo(Long productBarcode, String productName, int sumQuantity) {
        this.productBarcode = productBarcode;
        this.productName = productName;
        this.sumQuantity = sumQuantity;
    }

    public Long getProductBarcode() {
        return productBarcode;
    }

    public String getProductName() {
        return productName;
    }

    public int getSumQuantity() {
        return sumQuantity;
    }
}
