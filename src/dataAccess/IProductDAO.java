package dataAccess;

import model.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IProductDAO {
    int create(Product product) throws InsertionFailedException, DAORetrievalFailedException;
    void deleteByBarcode(int barcode) throws DeleteFailedException, DAORetrievalFailedException;
    int edit(Product product) throws UpdateFailedException, DAORetrievalFailedException;

    Product findByBarcode(int barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Product> findByName(String name) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Product> findAll() throws DAORetrievalFailedException;

    double currentPrice(int barcode) throws NotFoundException, DAORetrievalFailedException;
    void setPrice(int barcode, double price, int discountPercentage) throws InsertionFailedException, DAORetrievalFailedException;
    double priceAtDate(int barcode, LocalDate date) throws NotFoundException, DAORetrievalFailedException;

    int currentStock(int barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Integer> outOfStock() throws NotFoundException, DAORetrievalFailedException;

    int currentDiscount(int barcode) throws NotFoundException, DAORetrievalFailedException;
    int discountAtDate(int barcode, LocalDate date) throws NotFoundException, DAORetrievalFailedException;

}
