package controller;

import business.ProductManager;
import exceptions.*;
import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductController extends Controller {
    public static void create(String barcode, String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, String stringDay, String stringMonth, String stringYear) throws WrongTypeException, ProhibitedValueException, InsertionFailedException, DAORetrievalFailedException, FieldIsEmptyException {
        ProductManager.add(new Product(
                stringToBarcode(barcode),
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

    private static Long stringToBarcode(String barcodeAsString) throws WrongTypeException, FieldIsEmptyException {
        if (!barcodeAsString.isEmpty()) {
            try {
                return Long.parseLong(barcodeAsString);
            } catch (NumberFormatException numberFormatException) {
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

    public static int indexOfVatType(Character vatType) throws DAORetrievalFailedException {
        ArrayList<Vat> vats = getVats();
        ArrayList<Character> vatTypes = new ArrayList<>();
        for (Vat vat : vats) {
            vatTypes.add(vat.getType());
        }
        System.out.println(vatTypes.indexOf(vatType));
        return vatTypes.indexOf(vatType);
    }
    
    public static int indexOfCategoryName(int categoryId) throws DAORetrievalFailedException {
        ArrayList<Category> categories = getCategories();
        ArrayList<Integer> categoryIds = new ArrayList<>();
        for (Category category : categories) {
            categoryIds.add(category.getId());
        }
        return categoryIds.indexOf(categoryId);
    }
    
    public static String getBrandLabelById(int brandId) {
        //ArrayList<Brand> brands = getB;
        return "";
    }
}
