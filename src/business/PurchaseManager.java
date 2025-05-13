package business;

import exceptions.DAORetrievalFailedException;
import dataAccess.purchase.IPurchaseDAO;
import dataAccess.purchase.PurchaseDBAccess;
import model.Purchase;

import java.util.ArrayList;

public class PurchaseManager {
    private static IPurchaseDAO dao;

    static {
        dao = new PurchaseDBAccess();
    }

    public static ArrayList<Purchase> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }
}
