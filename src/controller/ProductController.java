package controller;

import business.ProductManager;
import dataAccess.*;
import model.*;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductController {
    public static void create(Long barcode, String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, String stringDay, String stringMonth, String stringYear) throws WrongTypeException, ProhibitedValueException, InsertionFailedException, DAORetrievalFailedException, FieldIsEmptyException {
        ProductManager.add(new Product(
                stringToBarcode(barcode.toString()),
                nameInputValidation(name),
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

    public static int edit(String barcode, String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, String stringDay, String stringMonth, String stringYear) throws WrongTypeException, ProhibitedValueException, DAORetrievalFailedException, UpdateFailedException, FieldIsEmptyException {
        return ProductManager.edit(new Product(
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

    private static String nameInputValidation(String name) {
        if (!name.isEmpty()) {
            return name;
        }
        return null;
    }

    private static BigDecimal stringToPrice(String priceAsString) throws WrongTypeException, ProhibitedValueException {
        if (!priceAsString.isEmpty()) {
            BigDecimal price;

            try {
                price = new BigDecimal(priceAsString);

                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    throw new ProhibitedValueException("Prix");
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
            throw new ProhibitedValueException("Date de mise en vente");
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

    public static int remove(String barcodeAsString) throws DeleteFailedException, WrongTypeException, FieldIsEmptyException, DAORetrievalFailedException {
        return ProductManager.remove(stringToBarcode(barcodeAsString));
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

    public static int getCurrentStock(String barcodeAsString) throws NotFoundException, DAORetrievalFailedException, WrongTypeException, FieldIsEmptyException {
        return ProductManager.getCurrentStock(stringToBarcode(barcodeAsString));
    }

    public static ArrayList<Integer> getOutOfStock() throws NotFoundException, DAORetrievalFailedException {
        return ProductManager.getOutOfStock();
    }
}
