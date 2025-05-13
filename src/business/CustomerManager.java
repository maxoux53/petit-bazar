package business;

import dataAccess.customer.ICustomerDAO;
import dataAccess.customer.CustomerDBAccess;
import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import model.Customer;

import java.util.ArrayList;

public class CustomerManager {
    private ICustomerDAO dao;

    public CustomerManager() {
        setDao(new CustomerDBAccess());
    }

    public void setDao(ICustomerDAO dao) {
        this.dao = dao;
    }

    public Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException {
        return dao.getByLoyaltyCardNumber(loyaltyCardNumber);
    }

    public ArrayList<Customer> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }
}
