package dataAccess;

import exceptions.*;
import model.City;
import model.Employee;
import model.IEmployeeInfoWrapper;

import java.util.ArrayList;

public interface IEmployeeDAO {
    int create(Employee employee, City city) throws InsertionFailedException, DAORetrievalFailedException;
    int delete(int id) throws DeleteFailedException, DAORetrievalFailedException;
    int update(Employee employee, City city) throws UpdateFailedException, DAORetrievalFailedException;

    IEmployeeInfoWrapper[] findById(int id) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<IEmployeeInfoWrapper[]> findAll() throws DAORetrievalFailedException;

    byte[] getPasswordHash(int id) throws NotFoundException, DAORetrievalFailedException;
    ArrayList<String> getAllCountries() throws DAORetrievalFailedException;
    ArrayList<String> getAllRoles() throws DAORetrievalFailedException;

}
