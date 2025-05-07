package dataAccessPackage.customer;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface ICustomerDAO {
    void addCustomer(Customer customer) throws ConnectionException, ExistingException;
    ArrayList<Customer> getAllCustomers() throws ConnectionException, NotFoundException;
    Customer getCustomerById(String id) throws ConnectionException, NotFoundException;
    void updateCustomer(Customer customer) throws ConnectionException, NotFoundException;
    void deleteCustomer(String id) throws ConnectionException, NotFoundException;
}
