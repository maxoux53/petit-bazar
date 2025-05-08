package dataAccess;

import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import model.Customer;
import java.util.ArrayList;

public interface ICustomerDAO {
    Customer findByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Customer> findAll() throws DAORetrievalFailedException;
}
