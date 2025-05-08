package controller;

import business.PurchaseManager;
import exceptions.DAORetrievalFailedException;
import model.Purchase;

import java.util.ArrayList;

public class PurchaseController extends Controller {
    public static ArrayList<Purchase> getAll() throws DAORetrievalFailedException {
        return PurchaseManager.getAll();
    }
}
