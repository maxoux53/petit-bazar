package business;

import dataAccess.customer.ICustomerDAO;
import dataAccess.customer.CustomerDBAccess;
import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import model.Customer;

import java.util.ArrayList;

public class CustomerManager {
    private static ICustomerDAO dao;

    static {
        dao = new CustomerDBAccess();
    }

    public static Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException {
        return dao.getByLoyaltyCardNumber(loyaltyCardNumber);
    }

    public static ArrayList<Customer> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }
}
