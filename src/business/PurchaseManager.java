package business;

import exceptions.DAORetrievalFailedException;
import interfaces.PurchaseDAO;
import dataAccess.PurchaseDBAccess;
import model.Purchase;

import java.util.ArrayList;

public class PurchaseManager {
    private PurchaseDAO dao;

    public PurchaseManager() {
        dao = new PurchaseDBAccess();
    }

    public ArrayList<Purchase> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }
}
