package business;

import exceptions.DAORetrievalFailedException;
import interfaces.PurchaseDAO;
import dataAccess.PurchaseDBAccess;
import model.Purchase;

import java.util.ArrayList;

public class PurchaseManager {
    private PurchaseDAO dao;

    public PurchaseManager() {
        setDao(new PurchaseDBAccess());
    }

    public void setDao(PurchaseDAO dao) {
        this.dao = dao;
    }

    public ArrayList<Purchase> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }
}
