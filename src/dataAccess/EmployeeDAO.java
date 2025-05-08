package dataAccess;

import exceptions.*;
import model.City;
import model.Employee;
import model.EmployeeInfoWrapper;

import java.util.ArrayList;

public interface EmployeeDAO {
    int create(Employee employee, City city) throws InsertionFailedException, DAORetrievalFailedException;
    int remove(int id) throws DeleteFailedException, DAORetrievalFailedException;
    int update(Employee employee, City city) throws UpdateFailedException, DAORetrievalFailedException;
    EmployeeInfoWrapper[] getById(int id) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Employee> getAll() throws DAORetrievalFailedException;
    byte[] getPasswordHash(int id) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<String> getAllCountries() throws DAORetrievalFailedException;
    ArrayList<String> getAllRoles() throws DAORetrievalFailedException;

}
