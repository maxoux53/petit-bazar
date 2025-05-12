package controller;

import business.ProductManager;
import com.sun.source.doctree.ThrowsTree;
import exceptions.*;
import model.*;

import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductController extends Controller {
    public static void create(String barcode, String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, String stringDay, String stringMonth, String stringYear) throws WrongTypeException, ProhibitedValueException, InsertionFailedException, DAORetrievalFailedException, FieldIsEmptyException {
        ProductManager.create(new Product(
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

    public static int update(String barcode, String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, String stringDay, String stringMonth, String stringYear) throws WrongTypeException, ProhibitedValueException, DAORetrievalFailedException, UpdateFailedException, FieldIsEmptyException {
        return ProductManager.update(new Product(
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
                throw new WrongTypeException("Code-barres");
            }
        } else {
            throw new FieldIsEmptyException("Code-barres");
        }
    }

    public static int remove(String barcodeAsString) throws DeleteFailedException, WrongTypeException, FieldIsEmptyException, DAORetrievalFailedException {
        return ProductManager.remove(stringToBarcode(barcodeAsString));
    }

    public static Product getByBarcode(String barcodeAsString) throws DAORetrievalFailedException, NotFoundException, WrongTypeException, FieldIsEmptyException {
        return ProductManager.getByBarcode(stringToBarcode(barcodeAsString));
    }
    
    public static String getCategoryLabelById(int categoryId) throws DAORetrievalFailedException, NotFoundException {
        return ProductManager.getCategoryLabelById(categoryId);
    }
    
    public static String getBrandLabelById(int brandId) throws DAORetrievalFailedException, NotFoundException {
        return ProductManager.getBrandLabelById(brandId);
    }

    public static int getOrCreateBrand(String name) throws DAORetrievalFailedException {
        return ProductManager.getOrCreateBrand(name);
    }

    public static ArrayList<Category> getAllCategories() throws DAORetrievalFailedException {
        return ProductManager.getAllCategories();
    }

    public static ArrayList<Vat> getAllVats() throws DAORetrievalFailedException {
        return ProductManager.getAllVats();
    }

    public static int getCurrentStock(String barcodeAsString) throws NotFoundException, DAORetrievalFailedException, WrongTypeException, FieldIsEmptyException {
        return ProductManager.getCurrentStock(stringToBarcode(barcodeAsString));
    }

    public static ArrayList<Integer> getOutOfStock() throws NotFoundException, DAORetrievalFailedException {
        return ProductManager.getOutOfStock();
    }
    
    private static ArrayList<Product> getAllProducts() throws DAORetrievalFailedException {
        return ProductManager.getAll();
    }
    
    public static DefaultTableModel infoTableModel() throws DAORetrievalFailedException, NotFoundException {
        String[] columnNames = {
                "Code-barres",
                "Nom",
                "Description",
                "Quantité",
                "Disponible",
                "Type de TVA",
                "Catégorie",
                "Marque",
                "Prix (€)",
                "Date de mise en rayon"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        ArrayList<Product> products = getAllProducts();

        for (Product product : products) {
            Object[] productInfos = new Object[columnNames.length];

            productInfos[0] = product.getBarcode();
            productInfos[1] = product.getName();
            productInfos[2] = product.getDescription();
            productInfos[3] = product.getAmount();
            productInfos[4] = product.getAvailable() ? "Oui" : "Non";
            productInfos[5] = product.getVatType();
            productInfos[6] = getCategoryLabelById(product.getCategoryId());
            productInfos[7] = getBrandLabelById(product.getBrandId());
            productInfos[8] = String.format("%.2f", product.getExclVatPrice());

            productInfos[9] = String.format("%02d/%02d/%04d",
                    product.getStartDate().getDayOfMonth(),
                    product.getStartDate().getMonthValue(),
                    product.getStartDate().getYear());

            model.addRow(productInfos);
        }

        return model;
    }

    public static int indexOfVatType(Character vatType) throws DAORetrievalFailedException {
        ArrayList<Vat> vats = getAllVats();
        ArrayList<Character> vatTypes = new ArrayList<>();

        for (Vat vat : vats) {
            vatTypes.add(vat.getType());
        }
        System.out.println(vatTypes.indexOf(vatType)); // DEBUG

        return vatTypes.indexOf(vatType);
    }
    
    public static int indexOfCategoryName(int categoryId) throws DAORetrievalFailedException {
        ArrayList<Category> categories = getAllCategories();
        ArrayList<Integer> categoryIds = new ArrayList<>();

        for (Category category : categories) {
            categoryIds.add(category.getId());
        }

        return categoryIds.indexOf(categoryId);
    }
}
