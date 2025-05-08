package dataAccess;

import exceptions.*;
import model.Category;
import model.Product;
import model.Vat;

import java.util.ArrayList;

public interface IProductDAO {
    int create(Product product) throws InsertionFailedException, DAORetrievalFailedException;
    int delete(Long barcode) throws DeleteFailedException, DAORetrievalFailedException;
    int update(Product product) throws UpdateFailedException, DAORetrievalFailedException;

    Product findByBarcode(Long barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Product> findByName(String name) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Product> findAll() throws DAORetrievalFailedException;

    Integer findOrCreateBrand(String brandName) throws DAORetrievalFailedException;

    ArrayList<Category> getAllCategories() throws DAORetrievalFailedException;
    ArrayList<Vat> getAllVatTypes() throws DAORetrievalFailedException;

    int currentStock(Long barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Integer> outOfStock() throws NotFoundException, DAORetrievalFailedException;
}
