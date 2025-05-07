package modelPackage;

public class OrderLine {
    private String id;
    private int quantity;
    private String idProduct;
    private String idPurchase;

    // CONSTRUCTOR

    public OrderLine() {}

    // GETTER

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public String getIdPurchase() {
        return idPurchase;
    }

    // SETTER

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
