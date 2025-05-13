package business;

import exceptions.DAORetrievalFailedException;
import dataAccess.purchase.IPurchaseDAO;
import dataAccess.purchase.PurchaseDBAccess;
import model.Purchase;

import java.util.ArrayList;

public class PurchaseManager {
    private IPurchaseDAO dao;

    public PurchaseManager() {
        setDao(new PurchaseDBAccess());
    }

    public void setDao(IPurchaseDAO dao) {
        this.dao = dao;
    }

    public ArrayList<Purchase> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }
}
