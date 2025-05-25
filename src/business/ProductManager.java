package business;

import dataAccess.*;
import exceptions.*;
import interfaces.ProductDAO;
import model.*;

import java.util.ArrayList;

public class ProductManager {
    private ProductDAO dao;

    public ProductManager() {
        setDao(new ProductDBAccess());
    }

    public void setDao (ProductDAO dao) {
        this.dao = dao;
    }

    public void create(Product product) throws InsertionFailedException, DAORetrievalFailedException {
        dao.create(product);
    }

    public int remove(Long barcode) throws DeleteFailedException, DAORetrievalFailedException {
        return dao.remove(barcode);
    }

    public int update(Product product) throws UpdateFailedException, DAORetrievalFailedException {
        return dao.update(product);
    }

    public Product getByBarcode(Long barcode) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException {
        return dao.getByBarcode(barcode);
    }

    public ArrayList<Product> searchByName(String name) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException {
        return dao.searchByName(name);
    }
    
    public Category getCategoryById(Integer categoryId) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException {
        return dao.getCategoryById(categoryId);
    }

    public Brand getBrandById(Integer brandId) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException {
        return dao.getBrandById(brandId);
    }
    
    public ArrayList<Product> getAll() throws DAORetrievalFailedException, ProhibitedValueException {
        return dao.getAll();
    }

    public int getOrCreateBrand(String name) throws DAORetrievalFailedException {
        return dao.getOrCreateBrandByName(name);
    }

    public ArrayList<Category> getAllCategories() throws DAORetrievalFailedException, ProhibitedValueException {
        return dao.getAllCategories();
    }

    public ArrayList<Vat> getAllVats() throws DAORetrievalFailedException, ProhibitedValueException {
        return dao.getAllVats();
    }

    public int getCurrentStock(Long barcode) throws NotFoundException, DAORetrievalFailedException {
        return dao.getCurrentStock(barcode);
    }

    public ArrayList<Product> getOutOfStock() throws DAORetrievalFailedException, ProhibitedValueException {
        return dao.getOutOfStock();
    }

    public boolean exists(long barcode) throws DAORetrievalFailedException {
        return dao.exists(barcode);
    }

    public ArrayList<ProductInformation> getProductInformationByBrand(int brandId) throws DAORetrievalFailedException {
        return dao.getProductInformationByBrand(brandId);
    }
}
