package interfaces;

import exceptions.DAORetrievalFailedException;
import exceptions.NotFoundException;
import exceptions.ProhibitedValueException;
import model.Customer;
import java.util.ArrayList;

public interface CustomerDAO {
    Customer getByLoyaltyCardNumber(Integer loyaltyCardNumber) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException;
    ArrayList<Customer> getAll() throws DAORetrievalFailedException, ProhibitedValueException;
}
