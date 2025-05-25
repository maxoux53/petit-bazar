package interfaces;

import exceptions.DAORetrievalFailedException;
import exceptions.ProhibitedValueException;
import model.LoyalCustomerPurchases;
import model.Purchase;
import model.PurchaseInformation;
import model.SalesInfo;

import java.time.LocalDate;
import java.util.ArrayList;

public interface PurchaseDAO {
    ArrayList<Purchase> getAll() throws DAORetrievalFailedException, ProhibitedValueException;
    ArrayList<SalesInfo> salesRanking(String categoryLabel) throws DAORetrievalFailedException;
    ArrayList<LoyalCustomerPurchases> loyalCustomerPurchasesRankingByEmployee(Integer employeeId) throws DAORetrievalFailedException;
    public ArrayList<PurchaseInformation> getPurchaseInformationByDate(LocalDate date) throws DAORetrievalFailedException;
}
