package controller;

import business.CustomerManager;
import dataAccess.DAORetrievalFailedException;
import dataAccess.NotFoundException;
import model.Customer;

import java.util.ArrayList;

public class CustomerController {
    public static Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException {
        return CustomerManager.getByLoyaltyCardNumber(loyaltyCardNumber);
    }

    public static ArrayList<Customer> getAll() throws DAORetrievalFailedException {
        return CustomerManager.getAll();
    }
}
