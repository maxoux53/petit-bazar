package business;

import dataAccess.*;
import exceptions.*;
import interfaces.ProductDAO;
import model.Category;
import model.Product;
import model.Vat;

import java.util.ArrayList;

public class ProductManager {
    private ProductDAO productDataAccess;

    public ProductManager() {
        productDataAccess = new ProductDBAccess();
    }

    public int create(Product product) throws InsertionFailedException, DAORetrievalFailedException {
        return productDataAccess.create(product);
    }

    public int remove(Long barcode) throws DeleteFailedException, DAORetrievalFailedException {
        return productDataAccess.remove(barcode);
    }

    public int update(Product product) throws DAORetrievalFailedException, UpdateFailedException {
        return productDataAccess.update(product);
    }

    public Product getByBarcode(Long barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.getByBarcode(barcode);
    }

    public ArrayList<Product> searchByName(String name) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.searchByName(name);
    }
    
    public String getCategoryLabelById(int categoryId) throws DAORetrievalFailedException, NotFoundException {
        return productDataAccess.getCategoryLabelById(categoryId);
    }

    public String getBrandLabelById(int brandId) throws DAORetrievalFailedException, NotFoundException {
        return productDataAccess.getBrandLabelById(brandId);
    }
    
    public ArrayList<Product> getAll() throws DAORetrievalFailedException {
        return productDataAccess.getAll();
    }

    public int getOrCreateBrand(String name) throws DAORetrievalFailedException {
        return productDataAccess.getOrCreateBrandByName(name);
    }

    public ArrayList<Category> getAllCategories() throws DAORetrievalFailedException {
        return productDataAccess.getAllCategories();
    }

    public ArrayList<Vat> getAllVats() throws DAORetrievalFailedException {
        return productDataAccess.getAllVats();
    }

    public int getCurrentStock(Long barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.getCurrentStock(barcode);
    }

    public ArrayList<Product> getOutOfStock() throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.getOutOfStock();
    }
}
