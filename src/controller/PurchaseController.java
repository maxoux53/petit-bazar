package controller;

import business.PurchaseManager;
import exceptions.DAORetrievalFailedException;
import model.Purchase;

import java.util.ArrayList;

public class PurchaseController {
    private PurchaseManager manager;

    public PurchaseController() {
        this.manager = new PurchaseManager();
    }

    public ArrayList<Purchase> getAll() throws DAORetrievalFailedException {
        return manager.getAll();
    }
}
