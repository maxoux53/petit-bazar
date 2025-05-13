package dataAccess.purchase;

import exceptions.DAORetrievalFailedException;
import model.Purchase;

import java.util.ArrayList;

public interface IPurchaseDAO {
    ArrayList<Purchase> getAll() throws DAORetrievalFailedException;
}
