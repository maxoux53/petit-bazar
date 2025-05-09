package interfaces;

import exceptions.DAORetrievalFailedException;
import model.Purchase;

import java.util.ArrayList;

public interface PurchaseDAO {
    ArrayList<Purchase> getAll() throws DAORetrievalFailedException;
}
