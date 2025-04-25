package controller;

import model.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ApplicationController {

    public static ArrayList<Vat> getVats() { // Will change
        ArrayList<Vat> vats = new ArrayList<>();
        vats.add(new Vat('A', 21));
        vats.add(new Vat('B', 12));
        vats.add(new Vat('C', 6));
        vats.add(new Vat('D', 0));
        
        return vats;
    }
    
    public static ArrayList<Category> getCategories() { // Will change
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Électronique"));
        categories.add(new Category(2, "Alimentation"));
        categories.add(new Category(3, "Vêtements"));
        categories.add(new Category(4, "Jardinage"));
        categories.add(new Category(5, "Librairie"));
        
        return categories;
    }
    
    public static ArrayList<Brand> getBrands() {
        ArrayList<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1, "Nike"));
        brands.add(new Brand(2, "Boni"));
        brands.add(new Brand(3, "Moulinex"));
        brands.add(new Brand(4, "Stihl"));
        brands.add(new Brand(5, "Spinelle"));

        return brands;
    }
    
    public static Product getProductByBarcode(int barcode) {
        // return méthodes pour récupérer un produit
        Product product = new Product(12345);
        product.setName("Chocolat");
        product.setDescription("C'est du chocolat");
        product.setAmount(3);
        product.setVatType('A');
        product.setCategoryId(2);
        product.setBrandId(2);
        product.setAvailable(true);
        
        return product;
    }
    
    public static void createProduct(String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, String stringDay, String stringMonth, String stringYear) throws FieldIsEmpty, WrongType, ProhibitedValue {
        Double price = null; // why do i have to initialize it to null???
        int day;
        int month;
        int year;

        // Price
        if (!priceAsString.isEmpty()) {
            try {
                price = Double.parseDouble(priceAsString);

                if (price < 0) {
                    throw new ProhibitedValue(priceAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongType("Prix");
            }
        }

        // Date
        try {
            day = Integer.parseInt(stringDay);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongType("Jour");
        }

        try {
            month = Integer.parseInt(stringMonth);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongType("Mois");
        }

        try {
            year = Integer.parseInt(stringYear);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongType("Année");
        }

        LocalDate startDate;
        try {
            startDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new ProhibitedValue(day + "/" + month + "/" + year);
        }

        // Product creation
        /*businessMethod (*/new Product(name, description, amount, isAvailable, vat, categoryId, brandId, price, startDate);
    }

}
