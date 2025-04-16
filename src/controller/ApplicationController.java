package controller;

import model.Category;
import model.Product;
import model.Vat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ApplicationController {
    // Static Methods
    public static ArrayList<Vat> getVats() { // Will change
        ArrayList<Vat> vats = new ArrayList<Vat>();
        vats.add(new Vat('A', 21));
        vats.add(new Vat('B', 12));
        vats.add(new Vat('C', 6));
        vats.add(new Vat('D', 0));
        
        return vats;
    }
    
    public static ArrayList<Category> getCategories() { // Will change
        ArrayList<Category> categories = new ArrayList<Category>();
        categories.add(new Category(1, "Électronique"));
        categories.add(new Category(2, "Alimentation"));
        categories.add(new Category(3, "Vêtements"));
        categories.add(new Category(4, "Jardinage"));
        categories.add(new Category(5, "Librairie"));
        
        return categories;
    } 
    
    public static void productIsValid(String name, String description, String stringPrice, Integer amount, String vat, String categoryName, String brand, String stringDay, String stringMonth, String stringYear, boolean available) throws FieldIsEmpty, WrongType {
        if (name.isEmpty()) {
            throw new FieldIsEmpty("Nom");
        }
        
        try {
            double price = Double.parseDouble(stringPrice);
            
            try {
                Integer day = Integer.parseInt(stringDay);
                
                try {
                    Integer month = Integer.parseInt(stringMonth);
                    
                    try {
                        Integer year = Integer.parseInt(stringYear);
                        
                    }
                    catch (NumberFormatException numberFormatException) {
                        throw new WrongType("Année");
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    throw new WrongType("Mois");
                }
            }
            catch (NumberFormatException numberFormatException) {
                throw new WrongType("Jour");
            }
        }
        catch (NumberFormatException numberFormatException) {
            throw new WrongType("Prix");
        }
        
        
        Character vatType = vat.charAt(0);
        
        ArrayList<Category> categories = getCategories();
        int iCategory = 0;
        while (!Objects.equals(categories.get(iCategory).getName(), categoryName)) {
            iCategory++;
        }
        
        Integer categoryId = categories.get(iCategory).getId();
        
        if (brand.isEmpty()) {
            throw new FieldIsEmpty("Marque");
        }

        //Product product = new Product()
    }
    
}
