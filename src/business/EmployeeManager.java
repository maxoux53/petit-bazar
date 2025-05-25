package business;

import dataAccess.*;
import exceptions.*;
import interfaces.EmployeeDAO;
import model.City;
import model.Employee;
import model.EmployeePlace;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class EmployeeManager {
    private EmployeeDAO dao;
    private MessageDigest digest;

    public EmployeeManager() {
        setDao(new EmployeeDBAccess());
    }

    public void setDao(EmployeeDAO dao) {
        this.dao = dao;
    }

    public void create(Employee employee) throws InsertionFailedException, DAORetrievalFailedException {
        dao.create(employee);
    }

    public int remove(Integer id) throws DeleteFailedException, DAORetrievalFailedException {
        return dao.remove(id);
    }

    public int update(Employee employee) throws UpdateFailedException, DAORetrievalFailedException {
        return dao.update(employee);
    }

    public Employee getById(Integer id) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException {
        return dao.getById(id);
    }

    public ArrayList<Employee> getAll() throws DAORetrievalFailedException, ProhibitedValueException {
        return dao.getAll();
    }

    public byte[] hashPassword(String password) throws HashFailedException {
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException | NullPointerException e) {
                throw new HashFailedException(e.getMessage());
            }
        }

        return digest.digest(password.getBytes());
    }

    public boolean checkPassword(char[] passwordAttempt, Integer id) throws HashFailedException, NotFoundException, DAORetrievalFailedException {
        return MessageDigest.isEqual(
                hashPassword(new String(passwordAttempt)),
                dao.getPasswordHash(id)
        );
    }

    public void setCity(City city) throws DAORetrievalFailedException {
        dao.setCity(city);
    }
    
    public City getCity(Integer zipCode, String name) throws DAORetrievalFailedException, NotFoundException, ProhibitedValueException {
        return dao.getCity(zipCode, name);
    }

    public ArrayList<String> getAllCountries() throws DAORetrievalFailedException {
        return dao.getAllCountries();
    }

    public ArrayList<String> getAllRoles() throws DAORetrievalFailedException {
        return dao.getAllRoles();
    }

    public ArrayList<EmployeePlace> getEmployeePlaceByEmployee(Integer employeeId) throws ProhibitedValueException, DAORetrievalFailedException {
        return dao.getEmployeePlaceByEmployee(employeeId);
    }
}
