package controller;

import business.ProductManager;
import exceptions.*;
import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ProductController {
    private ProductManager manager;

    public ProductController() {
        setManager(new ProductManager());
    }

    public void setManager(ProductManager manager) {
        this.manager = manager;
    }

    public void create(Product product) throws InsertionFailedException, DAORetrievalFailedException {
        manager.create(product);
    }

    public int update(Product product) throws UpdateFailedException, DAORetrievalFailedException {
        return manager.update(product);
    }

    public int remove(Long barcode) throws DeleteFailedException, WrongTypeException, FieldIsEmptyException, DAORetrievalFailedException {
        return manager.remove(barcode);
    }

    public Product getByBarcode(Long barcode) throws DAORetrievalFailedException, NotFoundException, WrongTypeException, FieldIsEmptyException, ProhibitedValueException {
        return manager.getByBarcode(barcode);
    }
    
    public Category getCategoryById(Integer categoryId) throws DAORetrievalFailedException, NotFoundException, ProhibitedValueException {
        return manager.getCategoryById(categoryId);
    }
    
    public Brand getBrandById(Integer brandId) throws DAORetrievalFailedException, NotFoundException, ProhibitedValueException {
        return manager.getBrandById(brandId);
    }

    public int getOrCreateBrand(String name) throws DAORetrievalFailedException {
        return manager.getOrCreateBrand(name);
    }

    public ArrayList<Category> getAllCategories() throws DAORetrievalFailedException, ProhibitedValueException {
        return manager.getAllCategories();
    }

    public ArrayList<Vat> getAllVats() throws DAORetrievalFailedException, ProhibitedValueException {
        return manager.getAllVats();
    }

    public ArrayList<Brand> getAllBrands() throws DAORetrievalFailedException, ProhibitedValueException {
        return manager.getAllBrands();
    }

    public int getCurrentStock(Long barcode) throws NotFoundException, DAORetrievalFailedException, WrongTypeException, FieldIsEmptyException {
        return manager.getCurrentStock(barcode);
    }

    public ArrayList<Product> getOutOfStock() throws DAORetrievalFailedException, ProhibitedValueException {
        return manager.getOutOfStock();
    }
    
    public ArrayList<Product> getAll() throws DAORetrievalFailedException, ProhibitedValueException {
        return manager.getAll();
    }

    public boolean exists(Long barcode) throws DAORetrievalFailedException {
        return manager.exists(barcode);
    }

    public ArrayList<ProductInformation> getProductInformationByBrand(Integer brandId) throws DAORetrievalFailedException {
        return manager.getProductInformationByBrand(brandId);
    }
}
