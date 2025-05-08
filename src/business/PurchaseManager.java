package business;

import exceptions.DAORetrievalFailedException;
import dataAccess.PurchaseDAO;
import dataAccess.PurchaseDBAccess;
import model.Purchase;

import java.util.ArrayList;

public class PurchaseManager {
    private static PurchaseDAO dao;

    static {
        dao = new PurchaseDBAccess();
    }

    public static ArrayList<Purchase> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }
}
