package dataAccess;

import model.Category;
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

    int currentStock(int barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Integer> outOfStock() throws NotFoundException, DAORetrievalFailedException;

    Category getCategory(int barcode) throws NotFoundException, DAORetrievalFailedException;

    int brand(String brandName) throws DAORetrievalFailedException;
}
