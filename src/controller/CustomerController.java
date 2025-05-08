package controller;

import business.CustomerManager;
import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import model.Customer;

import java.util.ArrayList;

public class CustomerController extends Controller {
    public static Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException {
        return CustomerManager.getByLoyaltyCardNumber(loyaltyCardNumber);
    }

    public static ArrayList<Customer> getAll() throws DAORetrievalFailedException {
        return CustomerManager.getAll();
    }
}
