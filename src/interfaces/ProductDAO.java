package interfaces;

import exceptions.*;
import model.*;

import java.util.ArrayList;

public interface ProductDAO {
    void create(Product product) throws InsertionFailedException, DAORetrievalFailedException;
    int remove(Long barcode) throws DeleteFailedException, DAORetrievalFailedException;
    int update(Product product) throws UpdateFailedException, DAORetrievalFailedException;

    Product getByBarcode(Long barcode) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException;
    ArrayList<Product> searchByName(String name) throws DAORetrievalFailedException, NotFoundException, ProhibitedValueException;
    Category getCategoryById(Integer categoryId) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException;
    Brand getBrandById(Integer brandId) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException;
    ArrayList<Product> getAll() throws DAORetrievalFailedException, ProhibitedValueException;

    Integer getOrCreateBrandByName(String brandName) throws DAORetrievalFailedException;

    ArrayList<Category> getAllCategories() throws DAORetrievalFailedException, ProhibitedValueException;
    ArrayList<Vat> getAllVats() throws DAORetrievalFailedException, ProhibitedValueException;

    int getCurrentStock(Long barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Product> getOutOfStock() throws DAORetrievalFailedException, ProhibitedValueException;
    boolean exists(Long barcode) throws DAORetrievalFailedException;
    ArrayList<ProductInformation> getProductInformationByBrand(Integer brandId) throws DAORetrievalFailedException;
}
