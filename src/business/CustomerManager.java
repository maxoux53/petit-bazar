package business;

import dataAccess.*;
import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import exceptions.ProhibitedValueException;
import interfaces.CustomerDAO;
import model.Customer;
import java.util.ArrayList;

public class CustomerManager {
    private CustomerDAO dao;

    public CustomerManager() {
        setDao(new CustomerDBAccess());
    }

    public void setDao(CustomerDAO dao) {
        this.dao = dao;
    }

    public Customer getByLoyaltyCardNumber(Integer loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException {
        return dao.getByLoyaltyCardNumber(loyaltyCardNumber);
    }

    public ArrayList<Customer> getAll() throws DAORetrievalFailedException, ProhibitedValueException {
        return dao.getAll();
    }
}
