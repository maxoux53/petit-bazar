package business;

import dataAccess.product.IProductDAO;
import dataAccess.product.ProductDBAccess;
import exceptions.*;
import model.Category;
import model.Product;
import model.Vat;

import java.util.ArrayList;

public class ProductManager {
    private static IProductDAO productDataAccess;

    static {
        productDataAccess = new ProductDBAccess();
    }

    public static int create(Product product) throws InsertionFailedException, DAORetrievalFailedException {
        return productDataAccess.create(product);
    }

    public static int remove(Long barcode) throws DeleteFailedException, DAORetrievalFailedException {
        return productDataAccess.remove(barcode);
    }

    public static int update(Product product) throws DAORetrievalFailedException, UpdateFailedException {
        return productDataAccess.update(product);
    }

    public static Product getByBarcode(Long barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.getByBarcode(barcode);
    }

    public static ArrayList<Product> searchByName(String name) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.searchByName(name);
    }
    
    public static String getCategoryLabelById(int categoryId) throws DAORetrievalFailedException, NotFoundException {
        return productDataAccess.getCategoryLabelById(categoryId);
    }

    public static String getBrandLabelById(int brandId) throws DAORetrievalFailedException, NotFoundException {
        return productDataAccess.getBrandLabelById(brandId);
    }
    
    public static ArrayList<Product> getAll() throws DAORetrievalFailedException {
        return productDataAccess.getAll();
    }

    public static int getOrCreateBrand(String name) throws DAORetrievalFailedException {
        return productDataAccess.getOrCreateBrandByName(name);
    }

    public static ArrayList<Category> getAllCategories() throws DAORetrievalFailedException {
        return productDataAccess.getAllCategories();
    }

    public static ArrayList<Vat> getAllVats() throws DAORetrievalFailedException {
        return productDataAccess.getAllVats();
    }

    public static int getCurrentStock(Long barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.getCurrentStock(barcode);
    }

    public static ArrayList<Integer> getOutOfStock() throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.getOutOfStock();
    }
}
