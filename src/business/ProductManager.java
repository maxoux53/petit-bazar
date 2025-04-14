package business;

import dataAccess.*;
import model.Product;
import java.util.ArrayList;

public class ProductManager {                           // static?
    private static IProductDAO productDataAccess;

    static {
        productDataAccess = new ProductDBAccess();
    }

    public static void add(Product product) throws InsertionFailedException, DAORetrievalFailedException {
        productDataAccess.create(product);
    }

    public static void remove(int barcode) throws DeleteFailedException, DAORetrievalFailedException {
        productDataAccess.deleteByBarcode(barcode);                                          // todo: handle returned int
    }

    public static Product getByBarcode(int barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.findByBarcode(barcode);
    }

    public static ArrayList<Product> getAll() throws DAORetrievalFailedException {
        return productDataAccess.findAll();
    }

    public static void update(Product product) throws DAORetrievalFailedException, UpdateFailedException {
        productDataAccess.edit(product);
    }
}
