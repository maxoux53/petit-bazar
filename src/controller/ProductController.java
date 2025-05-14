package controller;

import business.ProductManager;
import com.sun.source.doctree.ThrowsTree;
import exceptions.*;
import model.*;

import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ProductController {
    private ProductManager manager;

    public ProductController() {
        this.manager = new ProductManager();
    }

    public void create(Long barcode, String name, String description, BigDecimal price, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, LocalDate date) throws WrongTypeException, ProhibitedValueException, InsertionFailedException, DAORetrievalFailedException, FieldIsEmptyException {
        manager.create(new Product(
                barcode,
                name,
                description,
                amount,
                isAvailable,
                vat,
                categoryId,
                brandId,
                price,
                date
        ));
    }

    public int update(String barcode, String name, String description, String priceAsString, Integer amount, Boolean isAvailable, Character vat, Integer categoryId, Integer brandId, Date date) throws WrongTypeException, ProhibitedValueException, DAORetrievalFailedException, UpdateFailedException, FieldIsEmptyException {
        return manager.update(new Product(
                stringToBarcode(barcode),
                name,
                description,
                amount,
                isAvailable,
                vat,
                categoryId,
                brandId,
                stringToPrice(priceAsString),
                date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()
        ));
    }

    private String nameInputValidation(String name) {
        if (!name.isEmpty()) {
            return name;
        }
        return null;
    }

    private BigDecimal stringToPrice(String priceAsString) throws WrongTypeException, ProhibitedValueException {
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

    private Long stringToBarcode(String barcodeAsString) throws WrongTypeException, FieldIsEmptyException {
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

    public int remove(String barcodeAsString) throws DeleteFailedException, WrongTypeException, FieldIsEmptyException, DAORetrievalFailedException {
        return manager.remove(stringToBarcode(barcodeAsString));
    }

    public Product getByBarcode(String barcodeAsString) throws DAORetrievalFailedException, NotFoundException, WrongTypeException, FieldIsEmptyException {
        return manager.getByBarcode(stringToBarcode(barcodeAsString));
    }
    
    public String getCategoryLabelById(int categoryId) throws DAORetrievalFailedException, NotFoundException {
        return manager.getCategoryLabelById(categoryId);
    }
    
    public String getBrandLabelById(int brandId) throws DAORetrievalFailedException, NotFoundException {
        return manager.getBrandLabelById(brandId);
    }

    public int getOrCreateBrand(String name) throws DAORetrievalFailedException {
        return manager.getOrCreateBrand(name);
    }

    public ArrayList<Category> getAllCategories() throws DAORetrievalFailedException {
        return manager.getAllCategories();
    }

    public ArrayList<Vat> getAllVats() throws DAORetrievalFailedException {
        return manager.getAllVats();
    }

    public int getCurrentStock(String barcodeAsString) throws NotFoundException, DAORetrievalFailedException, WrongTypeException, FieldIsEmptyException {
        return manager.getCurrentStock(stringToBarcode(barcodeAsString));
    }

    public ArrayList<Integer> getOutOfStock() throws NotFoundException, DAORetrievalFailedException {
        return manager.getOutOfStock();
    }
    
    private ArrayList<Product> getAllProducts() throws DAORetrievalFailedException {
        return manager.getAll();
    }
    
    public DefaultTableModel infoTableModel() throws DAORetrievalFailedException, NotFoundException {
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
        Object[] productInfos = new Object[columnNames.length];
        
        for (Product product : products) {
            productInfos[0] = product.getBarcode();
            productInfos[1] = product.getName();
            productInfos[2] = product.getDescription();
            productInfos[3] = product.getAmount();
            productInfos[4] = product.getAvailable();
            productInfos[5] = product.getVatType();
            productInfos[6] = getCategoryLabelById(product.getCategoryId());
            productInfos[7] = getBrandLabelById(product.getBrandId());
            productInfos[8] = product.getExclVatPrice();
            productInfos[9] = product.getStartDate();
            
            model.addRow(productInfos);
        }

        return model;
    }

    public Integer indexOfVatType(char targetVatType) throws DAORetrievalFailedException {
        ArrayList<Vat> vats = getAllVats();

        int size = vats.size();
        for (int i = 0; i < size; i++) {
            if (vats.get(i).getType() == targetVatType) {
                return i;
            }
        }
        return null;
    }
    
    public Integer indexOfCategoryName(int targetCategoryId) throws DAORetrievalFailedException {
        ArrayList<Category> categories = getAllCategories();

        int size = categories.size();
        for (int i = 0; i < size; i++) {
            if (categories.get(i).getId() == targetCategoryId) {
                return i;
            }
        }
        return null;
    }
}
