package controller;

import business.CustomerManager;
import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import model.Customer;

import java.util.ArrayList;

public class CustomerController {
    private final CustomerManager manager;

    public CustomerController() {
        this.manager = new CustomerManager();
    }

    public Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException {
        return manager.getByLoyaltyCardNumber(loyaltyCardNumber);
    }

    public ArrayList<Customer> getAll() throws DAORetrievalFailedException {
        return manager.getAll();
    }
}
