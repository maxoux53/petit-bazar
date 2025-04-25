package model;

public class Vat {
    private Character type;
    private Integer rate;

    public Vat(Character type) {
        this.type = type;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
    
    // Getters
    public Character getType() {
        return type;
    }

    public Integer getRate() {
        return rate;
    }
}
