package business;

import dataAccess.*;
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
        return dao.findByLoyaltyCardNumber(loyaltyCardNumber);
    }

    public static ArrayList<Customer> getAll() throws DAORetrievalFailedException {
        return dao.findAll();
    }
}
