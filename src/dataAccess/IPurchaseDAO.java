package dataAccess;

import exceptions.DAORetrievalFailedException;
import model.Purchase;

import java.util.ArrayList;

public interface IPurchaseDAO {
    ArrayList<Purchase> findAll() throws DAORetrievalFailedException;
}
