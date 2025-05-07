package modelPackage;

public class Product {
    private String id;
    private int barcode;
    private String name;
    private String description;
    private int basePrice;
    private boolean isAvailable;
    private String idVAT;
    private String idCategory;
    private String idBrand;

    // CONSTRUCTOR

    public Product() {}

    // GETTER

    public String getId() {
        return id;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getIdVAT() {
        return idVAT;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public String getIdBrand() {
        return idBrand;
    }

    // SETTER

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
