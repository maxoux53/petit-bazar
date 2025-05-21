package interfaces;

import exceptions.*;
import model.City;
import model.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    int create(Employee employee) throws InsertionFailedException, DAORetrievalFailedException;
    int remove(Integer id) throws DeleteFailedException, DAORetrievalFailedException;
    int update(Employee employee) throws UpdateFailedException, DAORetrievalFailedException;
    Employee getById(Integer id) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException;
    ArrayList<Employee> getAll() throws DAORetrievalFailedException, ProhibitedValueException;
    byte[] getPasswordHash(Integer id) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<String> getAllCountries() throws DAORetrievalFailedException;
    ArrayList<String> getAllRoles() throws DAORetrievalFailedException;
}
