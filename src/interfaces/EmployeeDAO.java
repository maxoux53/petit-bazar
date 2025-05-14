package interfaces;

import exceptions.*;
import model.City;
import model.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    int create(Employee employee) throws InsertionFailedException, DAORetrievalFailedException;
    int remove(int id) throws DeleteFailedException, DAORetrievalFailedException;
    int update(Employee employee) throws UpdateFailedException, DAORetrievalFailedException;
    Employee getById(int id) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<Employee> getAll() throws DAORetrievalFailedException;
    byte[] getPasswordHash(int id) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<String> getAllCountries() throws DAORetrievalFailedException;
    ArrayList<String> getAllRoles() throws DAORetrievalFailedException;
}
