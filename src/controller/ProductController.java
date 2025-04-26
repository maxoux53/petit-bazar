package controller;

import business.ProductManager;
import dataAccess.DAORetrievalFailedException;
import dataAccess.InsertionFailedException;
import model.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductController {

    public static ArrayList<Vat> getVats() throws DAORetrievalFailedException {
        /*ArrayList<Vat> vats = new ArrayList<>();
        vats.add(new Vat('A', 21));
        vats.add(new Vat('B', 12));
        vats.add(new Vat('C', 6));
        vats.add(new Vat('D', 0));

        return vats;*/

        return ProductManager.getAllVats();
    }
    
    public static ArrayList<Category> getCategories() throws DAORetrievalFailedException { // Will change
        /*ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Électronique"));
        categories.add(new Category(2, "Alimentation"));
        categories.add(new Category(3, "Vêtements"));
        categories.add(new Category(4, "Jardinage"));
        categories.add(new Category(5, "Librairie"));
        
        return categories;*/

        return ProductManager.getAllCategories();
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

    public static int getBrandIdByName(String name) throws DAORetrievalFailedException {
        return ProductManager.setBrand(name);
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
    
    public static void createProduct(String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, String stringDay, String stringMonth, String stringYear) throws FieldIsEmptyException, WrongTypeException, ProhibitedValueException, InsertionFailedException, DAORetrievalFailedException {
        Double price = null; // why do i have to initialize it to null???
        int day;
        int month;
        int year;

        // Price
        if (!priceAsString.isEmpty()) {
            try {
                price = Double.parseDouble(priceAsString);

                if (price < 0) {
                    throw new ProhibitedValueException(priceAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Prix");
            }
        }

        // Date
        try {
            day = Integer.parseInt(stringDay);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Jour");
        }

        try {
            month = Integer.parseInt(stringMonth);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Mois");
        }

        try {
            year = Integer.parseInt(stringYear);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Année");
        }

        LocalDate startDate;
        try {
            startDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new ProhibitedValueException(day + "/" + month + "/" + year);
        }

        // Product creation
        ProductManager.add(new Product(name, description, amount, isAvailable, vat, categoryId, brandId, price, startDate));
    }

}
