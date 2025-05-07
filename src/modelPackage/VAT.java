package modelPackage;

public class VAT {
    private String id;
    private String type;
    private int rate;

    // CONSTRUCTOR

    public VAT() {}

    // GETTER

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getRate() {
        return rate;
    }

    // SETTER

    public void setRate(int rate) {
        this.rate = rate;
    }
}
