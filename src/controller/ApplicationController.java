package controller;

import model.Category;
import model.Vat;

import java.util.ArrayList;

public class ApplicationController {
    // Static Methods
    public static ArrayList<Vat> getVats() { // Will change
        ArrayList<Vat> vats = new ArrayList<Vat>();
        vats.add(new Vat('A', 6));
        vats.add(new Vat('B', 12));
        vats.add(new Vat('C', 21));
        
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
    
}
