package controller;

import business.EmployeeManager;
import business.HashFailedException;
import business.ProductManager;
import dataAccess.DAORetrievalFailedException;
import dataAccess.InsertionFailedException;
import dataAccess.NotFoundException;
import model.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeController {

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

    public static void createEmployee(String firstName, String lastName, char[] password, Boolean isActive, String street, String streetNumberAsString, String unitNumberAsString, String roleLabel, String dayAsString, String monthAsString, String yearAsString, String managerIdAsString, String zipCodeAsString, String cityName) throws HashFailedException, InsertionFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException {
        byte[] passwordHash = null;
        Integer streetNumber = null;
        Integer unitNumber = null;
        LocalDate hireDate;
        Integer managerId = null;
        Integer zipCode = null;

        // Password
        if (password != null) {
            passwordHash = EmployeeManager.hashPassword(new String(password));
        }

        // Street number
        if (!streetNumberAsString.isEmpty()) {
            try {
                streetNumber = Integer.parseInt(streetNumberAsString);

                if (streetNumber < 0) {
                    throw new ProhibitedValueException(streetNumberAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Numéro de rue");
            }
        }

        // Unit number
        if (!unitNumberAsString.isEmpty()) {
            try {
                unitNumber = Integer.parseInt(unitNumberAsString);

                if (unitNumber < 0) {
                    throw new ProhibitedValueException(unitNumberAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Numéro d'unité");
            }
        }

        // Hire date
        int day;
        try {
            day = Integer.parseInt(dayAsString);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Jour");
        }

        int month;
        try {
            month = Integer.parseInt(monthAsString);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Mois");
        }

        int year;
        try {
            year = Integer.parseInt(yearAsString);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Année");
        }

        try {
            hireDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new ProhibitedValueException(day + "/" + month + "/" + year);
        }

        // Manager ID
        if (!managerIdAsString.isEmpty()) {
            try {
                managerId = Integer.parseInt(managerIdAsString);

                if (managerId < 0) {
                    throw new ProhibitedValueException(managerIdAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Identifiant du gérant");
            }
        }

        // Zip code
        if (!zipCodeAsString.isEmpty()) {
            try {
                zipCode = Integer.parseInt(zipCodeAsString);

                if (zipCode < 0) {
                    throw new ProhibitedValueException(zipCodeAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Code postal");
            }
        }



        EmployeeManager.add(
                new Employee(firstName, lastName, passwordHash, isActive, street, streetNumber, unitNumber, roleLabel, hireDate, managerId, zipCode, cityName),
                new City(zipCode, cityName)
        );
    }

    public static boolean employeeLogin(String username, char[] passwordAttempt) throws HashFailedException, DAORetrievalFailedException, NotFoundException {
        return EmployeeManager.checkPassword(passwordAttempt, Integer.parseInt(username));
    }

}
