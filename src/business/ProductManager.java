package business;

import dataAccess.*;
import model.Category;
import model.Product;
import model.Vat;

import java.util.ArrayList;

public class ProductManager {
    private static IProductDAO productDataAccess;

    static {
        productDataAccess = new ProductDBAccess();
    }

    public static int add(Product product) throws InsertionFailedException, DAORetrievalFailedException {
        return productDataAccess.create(product);
    }

    public static int remove(Long barcode) throws DeleteFailedException, DAORetrievalFailedException {
        return productDataAccess.delete(barcode);
    }

    public static int edit(Product product) throws DAORetrievalFailedException, UpdateFailedException {
        return productDataAccess.update(product);
    }

    public static Product getByBarcode(Long barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.findByBarcode(barcode);
    }

    public static ArrayList<Product> searchByName(String name) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.findByName(name);
    }

    public static ArrayList<Product> getAll() throws DAORetrievalFailedException {
        return productDataAccess.findAll();
    }

    public static int getOrCreateBrand(String name) throws DAORetrievalFailedException {
        return productDataAccess.findOrCreateBrand(name);
    }

    public static ArrayList<Category> getAllCategories() throws DAORetrievalFailedException {
        return productDataAccess.getAllCategories();
    }

    public static ArrayList<Vat> getAllVats() throws DAORetrievalFailedException {
        return productDataAccess.getAllVatTypes();
    }

    public static int getCurrentStock(Long barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.currentStock(barcode);
    }

    public static ArrayList<Integer> getOutOfStock() throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.outOfStock();
    }
}
