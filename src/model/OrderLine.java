package model;

public class OrderLine {
    private Integer quantity;
    private Long productBarcode;
    private Long purchaseId;

    public OrderLine(Integer quantity, Long productBarcode, Long purchaseId) {
        this.quantity = quantity;
        this.productBarcode = productBarcode;
        this.purchaseId = purchaseId;
    }
}
