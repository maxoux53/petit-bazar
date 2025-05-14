package business;

import dataAccess.*;
import exceptions.*;
import interfaces.ProductDAO;
import model.Category;
import model.Product;
import model.Vat;

import java.util.ArrayList;

public class ProductManager {
    private ProductDAO dao;

    public ProductManager() {
        setDao(new ProductDBAccess());
    }

    public void setDao (ProductDAO dao) {
        this.dao = dao;
    }

    public int create(Product product) throws InsertionFailedException, DAORetrievalFailedException {
        return dao.create(product);
    }

    public int remove(Long barcode) throws DeleteFailedException, DAORetrievalFailedException {
        return dao.remove(barcode);
    }

    public int update(Product product) throws DAORetrievalFailedException, UpdateFailedException {
        return dao.update(product);
    }

    public Product getByBarcode(Long barcode) throws NotFoundException, DAORetrievalFailedException {
        return dao.getByBarcode(barcode);
    }

    public ArrayList<Product> searchByName(String name) throws NotFoundException, DAORetrievalFailedException {
        return dao.searchByName(name);
    }
    
    public String getCategoryLabelById(int categoryId) throws DAORetrievalFailedException, NotFoundException {
        return dao.getCategoryLabelById(categoryId);
    }

    public String getBrandLabelById(int brandId) throws DAORetrievalFailedException, NotFoundException {
        return dao.getBrandLabelById(brandId);
    }
    
    public ArrayList<Product> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }

    public int getOrCreateBrand(String name) throws DAORetrievalFailedException {
        return dao.getOrCreateBrandByName(name);
    }

    public ArrayList<Category> getAllCategories() throws DAORetrievalFailedException {
        return dao.getAllCategories();
    }

    public ArrayList<Vat> getAllVats() throws DAORetrievalFailedException {
        return dao.getAllVats();
    }

    public int getCurrentStock(Long barcode) throws NotFoundException, DAORetrievalFailedException {
        return dao.getCurrentStock(barcode);
    }

    public ArrayList<Integer> getOutOfStock() throws NotFoundException, DAORetrievalFailedException {
        return dao.getOutOfStock();
    }
}
