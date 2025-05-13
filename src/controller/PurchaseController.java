package controller;

import business.PurchaseManager;
import exceptions.DAORetrievalFailedException;
import model.Purchase;

import java.util.ArrayList;

public class PurchaseController extends Controller {
    private PurchaseManager manager;

    public PurchaseController() {
        setManager(new PurchaseManager());
    }

    public void setManager(PurchaseManager manager) {
        this.manager = manager;
    }

    public ArrayList<Purchase> getAll() throws DAORetrievalFailedException {
        return manager.getAll();
    }
}
