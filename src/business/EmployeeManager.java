package business;

import dataAccess.employee.IEmployeeDAO;
import dataAccess.employee.EmployeeDBAccess;
import exceptions.*;
import model.City;
import model.Employee;
import model.IEmployeeInfoWrapper;

import java.security.MessageDigest;
import java.util.ArrayList;

public class EmployeeManager {
    private IEmployeeDAO dao;
    private MessageDigest digest;

    public EmployeeManager() {
        setDao(new EmployeeDBAccess());
    }

    public void setDao(IEmployeeDAO dao) {
        this.dao = dao;
    }

    public int create(Employee employee, City city) throws InsertionFailedException, DAORetrievalFailedException {
        return dao.create(employee, city);
    }

    public int remove(int id) throws DeleteFailedException, DAORetrievalFailedException {
        return dao.remove(id);
    }

    public int update(Employee employee, City city) throws UpdateFailedException, DAORetrievalFailedException {
        return dao.update(employee, city);
    }

    public IEmployeeInfoWrapper[] getById(int id) throws NotFoundException, DAORetrievalFailedException {
        return dao.getById(id);
    }

    public ArrayList<Employee> getAll() throws DAORetrievalFailedException {
        return dao.getAll();
    }

    public byte[] hashPassword(String password) throws HashFailedException {
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (Exception e) {
                throw new HashFailedException(e.getMessage());
            }
        }

        return digest.digest(password.getBytes());
    }

    public boolean checkPassword(char[] passwordAttempt, int id) throws HashFailedException, NotFoundException, DAORetrievalFailedException {
        return MessageDigest.isEqual(
                hashPassword(new String(passwordAttempt)),
                dao.getPasswordHash(id)
        );
    }

    public ArrayList<String> getAllCountries() throws DAORetrievalFailedException {
        return dao.getAllCountries();
    }

    public ArrayList<String> getAllRoles() throws DAORetrievalFailedException {
        return dao.getAllRoles();
    }
}
