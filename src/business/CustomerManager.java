package business;

import dataAccess.*;
import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import interfaces.CustomerDAO;
import model.Customer;
import java.util.ArrayList;

public class CustomerManager {
    private CustomerDAO dao;

    public CustomerManager() {
        dao = new CustomerDBAccess();
    }

    public Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException {
        return dao.getByLoyaltyCardNumber(loyaltyCardNumber);
    }

    public ArrayList<Customer> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }
}
