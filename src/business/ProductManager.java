package business;

import dataAccess.*;
import model.Product;

import java.time.LocalDate;
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

    public static void setPrice(int barcode, double price, int discountPercentage) throws InsertionFailedException, DAORetrievalFailedException {
        productDataAccess.setPrice(barcode, price, discountPercentage);
    }

    public static double getCurrentPrice(int barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.currentPrice(barcode);
    }

    public static double getPriceAtDate(int barcode, LocalDate date) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.priceAtDate(barcode, date);
    }

    public static int getCurrentStock(int barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.currentStock(barcode);
    }

    public static ArrayList<Integer> getOutOfStock() throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.outOfStock();
    }

    public static int getCurrentDiscount(int barcode) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.currentDiscount(barcode);
    }

    public static int getDiscountAtDate(int barcode, LocalDate date) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.discountAtDate(barcode, date);
    }

    public static ArrayList<Product> searchByName(String name) throws NotFoundException, DAORetrievalFailedException {
        return productDataAccess.findByName(name);
    }
}
