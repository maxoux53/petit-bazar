package controller;

import business.CustomerManager;
import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import exceptions.ProhibitedValueException;
import model.Customer;

import java.util.ArrayList;

public class CustomerController {
    private CustomerManager manager;

    public CustomerController() {
        setManager(new CustomerManager());
    }

    public void setManager(CustomerManager manager) {
        this.manager = manager;
    }

    public Customer getByLoyaltyCardNumber(Integer loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException {
        return manager.getByLoyaltyCardNumber(loyaltyCardNumber);
    }

    public ArrayList<Customer> getAll() throws DAORetrievalFailedException, ProhibitedValueException {
        return manager.getAll();
    }
}
