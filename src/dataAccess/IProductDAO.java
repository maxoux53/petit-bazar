package dataAccess;

import model.Product;
import java.util.ArrayList;

public interface IProductDAO {
    int create(Product product) throws InsertionFailedException, DAORetrievalFailedException;
    void deleteByBarcode(int barcode) throws DeleteFailedException, DAORetrievalFailedException;
    Product findByBarcode(int barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Product> findAll() throws DAORetrievalFailedException;
    int edit(Product product) throws UpdateFailedException, DAORetrievalFailedException;

}
