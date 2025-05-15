package model;

import exceptions.ProhibitedValueException;

public class OrderLine {
    private Integer quantity;
    private Long productBarcode;
    private Long purchaseId;

    public OrderLine(Integer quantity, Long productBarcode, Long purchaseId) throws ProhibitedValueException {
        setQuantity(quantity);
        this.productBarcode = productBarcode;
        this.purchaseId = purchaseId;
    }

    public void setQuantity(Integer quantity) throws ProhibitedValueException {
        if (quantity <= 0) {
            throw new ProhibitedValueException("La quantité ne peut pas être négative");
        }

        this.quantity = quantity;
    }
}
