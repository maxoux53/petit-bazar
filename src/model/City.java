package model;

import exceptions.ProhibitedValueException;

public class City {
    private Integer zipCode;
    private String name;
    private String country;

    public City(Integer zipCode, String name, String country) throws ProhibitedValueException {
        setZipCode(zipCode);
        setName(name);
        this.country = country;
    }

    // Setters
    public void setZipCode(Integer zipCode) throws ProhibitedValueException {
        if (zipCode != null && (zipCode < 1 || zipCode > 99999)) {
            throw new ProhibitedValueException("Le code postal doit être compris entre 1 et 99999");
        }

        this.zipCode = zipCode;
    }

    public void setName(String name) throws ProhibitedValueException {
        if (name != null && name.length() > 20) {
            throw new ProhibitedValueException("Le nom de la ville ne peut pas dépasser 20 caractères");
        }

        this.name = name;
    }

    // Getters
    public Integer getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
