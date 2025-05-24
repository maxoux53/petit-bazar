package controller;

import business.EmployeeManager;
import exceptions.HashFailedException;
import exceptions.*;
import model.*;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeController {
    private EmployeeManager manager;

    public EmployeeController() {
        setManager(new EmployeeManager());
    }

    public void setManager(EmployeeManager manager) {
        this.manager = manager;
    }

    public int create(Employee employee) throws HashFailedException, InsertionFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException {
        manager.create(employee);

        return 0;
    }

    public int remove(Integer id) throws DeleteFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException {
        return manager.remove(id);
    }

    public int update(Employee employee) throws HashFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException, UpdateFailedException {
        return manager.update(employee);
    }

    public Employee getEmployeeById(Integer id) throws NotFoundException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException {
        return manager.getById(id);
    }

    public ArrayList<Employee> getAllEmployees() throws DAORetrievalFailedException, ProhibitedValueException {
        return manager.getAll();
    }

    public boolean isPasswordCorrect(String username, char[] passwordAttempt) throws HashFailedException, DAORetrievalFailedException, NotFoundException {
        return manager.checkPassword(passwordAttempt, Integer.parseInt(username));
    }

    public ArrayList<String> getAllCountries() throws DAORetrievalFailedException {
        return manager.getAllCountries();
    }

    public ArrayList<String> getAllRoles() throws DAORetrievalFailedException {
        return manager.getAllRoles();
    }

    public byte[] hashPassword(String password) throws HashFailedException {
        return manager.hashPassword(password);
    }
}
