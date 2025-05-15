package model;

import exceptions.ProhibitedValueException;

public class Category {
    private Integer id;
    private String label;

    public Category(Integer id, String label) throws ProhibitedValueException {
        this.id = id;
        setLabel(label);
    }

    // Setters
    public void setLabel(String label) throws ProhibitedValueException {
        if (label.length() > 20) {
            throw new ProhibitedValueException("Le label de la catégorie ne peut pas dépasser 20 caractères");
        }

        this.label = label;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
