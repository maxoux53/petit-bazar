package dataAccess;

import model.Product;
import java.util.ArrayList;

public interface IProductDAO {
    void create(Product product) throws InsertionFailedException;
    void delete(Product product) throws DeleteFailedException;
    Product findByBarcode(int barcode) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Product> findAll() throws DAORetrievalFailedException;
    void edit(Product product) throws UpdateFailedException;

}
