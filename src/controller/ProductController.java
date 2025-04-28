package controller;

import business.ProductManager;
import dataAccess.DAORetrievalFailedException;
import dataAccess.InsertionFailedException;
import dataAccess.NotFoundException;
import dataAccess.UpdateFailedException;
import model.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductController {
    public static void create(String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, String stringDay, String stringMonth, String stringYear) throws WrongTypeException, ProhibitedValueException, InsertionFailedException, DAORetrievalFailedException {
        ProductManager.add(new Product(
                name,
                description,
                amount,
                isAvailable,
                vat,
                categoryId,
                brandId,
                stringToPrice(priceAsString),
                stringToDate(stringDay, stringMonth, stringYear)
        ));
    }

    public static void edit(String barcode, String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, String stringDay, String stringMonth, String stringYear) throws WrongTypeException, ProhibitedValueException, DAORetrievalFailedException, UpdateFailedException, FieldIsEmptyException {
        ProductManager.edit(new Product(
                stringToBarcode(barcode),
                name,
                description,
                amount,
                isAvailable,
                vat,
                categoryId,
                brandId,
                stringToPrice(priceAsString),
                stringToDate(stringDay, stringMonth, stringYear)
        ));
    }

    private static Double stringToPrice(String priceAsString) throws WrongTypeException, ProhibitedValueException {
        if (!priceAsString.isEmpty()) {
            double price;

            try {
                price = Double.parseDouble(priceAsString);

                if (price < 0) {
                    throw new ProhibitedValueException(priceAsString);
                }

                return price;
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Prix");
            }
        }
        return null;
    }

    private static LocalDate stringToDate(String stringDay, String stringMonth, String stringYear) throws WrongTypeException, ProhibitedValueException {
        int day;
        try {
            day = Integer.parseInt(stringDay);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Jour");
        }

        int month;
        try {
            month = Integer.parseInt(stringMonth);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Mois");
        }

        int year;
        try {
            year = Integer.parseInt(stringYear);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Année");
        }

        try {
            return LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new ProhibitedValueException(day + "/" + month + "/" + year);
        }
    }

    private static Long stringToBarcode(String barcodeAsString) throws WrongTypeException, FieldIsEmptyException {
        if (!barcodeAsString.isEmpty()) {
            try {
                return Long.parseLong(barcodeAsString);
            } catch (NumberFormatException numberFormatException) {
                // DEBUG ONLY ↓↓
                System.out.println(numberFormatException.getMessage());
                throw new WrongTypeException("Code barre");
            }
        } else {
            throw new FieldIsEmptyException("Code barre");
        }
    }

    public static Product getProductByBarcode(String barcodeAsString) throws DAORetrievalFailedException, NotFoundException, WrongTypeException, FieldIsEmptyException {
        return ProductManager.getByBarcode(stringToBarcode(barcodeAsString));
    }

    public static int getOrCreateBrand(String name) throws DAORetrievalFailedException {
        return ProductManager.getOrCreateBrand(name);
    }

    public static ArrayList<Category> getCategories() throws DAORetrievalFailedException {
        return ProductManager.getAllCategories();
    }

    public static ArrayList<Vat> getVats() throws DAORetrievalFailedException {
        return ProductManager.getAllVats();
    }
}
