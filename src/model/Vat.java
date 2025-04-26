package model;

public class Vat {
    private Character type;
    private Integer rate;

    public Vat(Character type) {
        this.type = type;
    }

    // TESTING PURPOSES ONLY ↓↓
    public Vat(Character type, Integer rate) {
        this.type = type;
        this.rate = rate;
    }
    // REMOVE LATER, USELESS ↑↑

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
