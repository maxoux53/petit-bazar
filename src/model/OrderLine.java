package model;

public class OrderLine {
    private Integer quantity;
    private Integer productBarcode;
    private Integer purchaseId;

    public OrderLine(Integer quantity, Integer productBarcode, Integer purchaseId) {
        this.quantity = quantity;
        this.productBarcode = productBarcode;
        this.purchaseId = purchaseId;
    }
}
