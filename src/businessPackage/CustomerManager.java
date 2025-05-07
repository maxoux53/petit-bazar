package businessPackage;

import dataAccessPackage.customer.CustomerDBAccess;
import dataAccessPackage.customer.ICustomerDAO;
import exceptionPackage.*;
import modelPackage.Customer;

import java.util.ArrayList;

public class CustomerManager {
    private ICustomerDAO dao;

    public CustomerManager() {
        setDao(new CustomerDBAccess());
    }

    public void setDao(ICustomerDAO dao) {
        this.dao = dao;
    }

    // CRUD

    public void addCustomer(Customer customer) throws ConnectionException, ExistingException {
        dao.addCustomer(customer);
    }

    public ArrayList<Customer> getAllCustomers() throws ConnectionException, NotFoundException {
        return dao.getAllCustomers();
    }

    public Customer getCustomerById(String id) throws ConnectionException, NotFoundException {
        return dao.getCustomerById(id);
    }

    public void updateCustomer(Customer customer) throws ConnectionException, NotFoundException {
        dao.updateCustomer(customer);
    }

    public void deleteCustomer(String id) throws ConnectionException, NotFoundException {
        dao.deleteCustomer(id);
    }
}