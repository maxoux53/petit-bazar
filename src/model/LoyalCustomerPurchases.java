package model;

public class LoyalCustomerPurchases {
    private String customerLastName;
    private String customerFirstName;
    private int purchaseNb;

    public LoyalCustomerPurchases(String customerLastName, String customerFirstName, int purchaseNb) {
        this.customerLastName = customerLastName;
        this.customerFirstName = customerFirstName;
        this.purchaseNb = purchaseNb;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public int getPurchaseNb() {
        return purchaseNb;
    }
}
