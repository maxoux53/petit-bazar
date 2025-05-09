package interfaces;

import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import model.Customer;
import java.util.ArrayList;

public interface CustomerDAO {
    Customer getByLoyaltyCardNumber(int loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Customer> getAll() throws DAORetrievalFailedException;
}
