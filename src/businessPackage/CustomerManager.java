package businessPackage;

import modelPackage.Customer;

import java.util.ArrayList;

public class CustomerManager { // PENSER A GERER LES EXCEPTIONS !!!
    private ICustomerDAO dao;

    public CustomerManager() {
        setDao(new CustomerDBAccess());
    }

    public void setDao(ICustomerDAO dao) {
        this.dao = dao;
    }

    // CRUD

    public void addCustomer(Customer customer) {
        dao.addCustomer(customer);
    }

    public ArrayList<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    public Customer getCustomerById(String id) {
        return dao.getCustomerById(id);
    }

    public void updateCustomer(Customer customer) {
        dao.updateCustomer(customer);
    }

    public void deleteCustomer(String id) {
        dao.deleteCustomer(id);
    }
}