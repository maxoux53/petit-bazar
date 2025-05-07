package controllerPackage;

import exceptionPackage.*;
import modelPackage.Customer;
import businessPackage.CustomerManager;

import java.util.ArrayList;

public class CustomerController {
    private CustomerManager customerManager;

    public CustomerController(){
        customerManager = new CustomerManager();
    }

    public void addCustomer(Customer customer) throws ConnectionException, ExistingException {
        customerManager.addCustomer(customer);
    }

    public ArrayList<Customer> getAllCustomers() throws ConnectionException, NotFoundException {
        return customerManager.getAllCustomers();
    }

    public Customer getCustomerById(String id) throws ConnectionException, NotFoundException {
        return customerManager.getCustomerById(id);
    }

    public void updateMember(Customer customer) throws ConnectionException, NotFoundException {
        customerManager.updateCustomer(customer);
    }

    public void deleteCustomer(String id) throws ConnectionException, NotFoundException {
        customerManager.deleteCustomer(id);
    }
}
