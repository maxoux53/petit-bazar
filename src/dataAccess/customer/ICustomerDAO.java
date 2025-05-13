package dataAccess.customer;

import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import model.Customer;

import java.util.ArrayList;

public interface ICustomerDAO {
    Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Customer> getAll() throws DAORetrievalFailedException;
}
