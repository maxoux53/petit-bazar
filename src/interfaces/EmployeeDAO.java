package interfaces;

import exceptions.*;
import model.City;
import model.Employee;
import model.EmployeePlace;

import java.util.ArrayList;

public interface EmployeeDAO {
    void create(Employee employee) throws InsertionFailedException, DAORetrievalFailedException;
    int remove(Integer id) throws DeleteFailedException, DAORetrievalFailedException;
    int update(Employee employee) throws UpdateFailedException, DAORetrievalFailedException;
    Employee getById(Integer id) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException;
    ArrayList<Employee> getAll() throws DAORetrievalFailedException, ProhibitedValueException;
    byte[] getPasswordHash(Integer id) throws NotFoundException, DAORetrievalFailedException;
    void setCity(City city) throws DAORetrievalFailedException;
    City getCity(Integer zipCode, String name) throws DAORetrievalFailedException, NotFoundException, ProhibitedValueException;
    ArrayList<String> getAllCountries() throws DAORetrievalFailedException;
    ArrayList<String> getAllRoles() throws DAORetrievalFailedException;
    public ArrayList<EmployeePlace> getEmployeePlaceByEmployee(int employeeId) throws ProhibitedValueException, DAORetrievalFailedException;
}
