package model;

import exceptions.ProhibitedValueException;

public class Vat {
    private Character type;
    private Integer rate;

    public Vat(Character type, Integer rate) throws ProhibitedValueException {
        this.type = type;
        setRate(rate);
    }

    // Setters
    public void setRate(Integer rate) throws ProhibitedValueException {
        if (rate < 0 || rate > 100) {
            throw new ProhibitedValueException("Le taux de TVA doit être compris entre 0 et 100");
        }

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
