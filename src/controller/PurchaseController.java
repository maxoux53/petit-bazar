package controller;

import business.PurchaseManager;
import exceptions.DAORetrievalFailedException;
import exceptions.ProhibitedValueException;
import model.LoyalCustomerPurchases;
import model.Purchase;
import model.PurchaseInformation;
import model.SalesInfo;

import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseController {
    private PurchaseManager manager;

    public PurchaseController() {
        this.manager = new PurchaseManager();
    }

    public ArrayList<Purchase> getAll() throws DAORetrievalFailedException, ProhibitedValueException {
        return manager.getAll();
    }

    public ArrayList<SalesInfo> salesRanking(String categoryLabel) throws DAORetrievalFailedException {
        return manager.salesRanking(categoryLabel);
    }

    public ArrayList<LoyalCustomerPurchases> loyalCustomerPurchasesRankingByEmployee(Integer employeeId) throws DAORetrievalFailedException {
        return manager.loyalCustomerPurchasesRankingByEmployee(employeeId);
    }

    public ArrayList<PurchaseInformation> getPurchaseInformationByDate(LocalDate date) throws DAORetrievalFailedException {
        return manager.getPurchaseInformationByDate(date);
    }
}
