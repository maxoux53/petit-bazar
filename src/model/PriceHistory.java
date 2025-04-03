package model;

import java.time.LocalDate;

public class PriceHistory {
    private Double exclVatPrice;
    private Integer discount;
    private LocalDate startDate;
    private Integer productBarcode;

    public PriceHistory(Double exclVatPrice, Integer discount, LocalDate startDate, Integer productBarcode) {
        this.exclVatPrice = exclVatPrice;
        this.discount = discount;
        this.startDate = startDate;
        this.productBarcode = productBarcode;
    }
}
