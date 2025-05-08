package dataAccess;

import exceptions.*;
import model.Category;
import model.Product;
import model.Vat;

import java.util.ArrayList;

public interface ProductDAO {
    int create(Product product) throws InsertionFailedException, DAORetrievalFailedException;
    int remove(Long barcode) throws DeleteFailedException, DAORetrievalFailedException;
    int update(Product product) throws UpdateFailedException, DAORetrievalFailedException;

    Product getByBarcode(Long barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Product> searchByName(String name) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Product> getAll() throws DAORetrievalFailedException;

    Integer getOrCreateBrand(String brandName) throws DAORetrievalFailedException;

    ArrayList<Category> getAllCategories() throws DAORetrievalFailedException;
    ArrayList<Vat> getAllVats() throws DAORetrievalFailedException;

    int getCurrentStock(Long barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Integer> getOutOfStock() throws NotFoundException, DAORetrievalFailedException;
}
