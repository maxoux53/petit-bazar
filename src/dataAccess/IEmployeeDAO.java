package dataAccess;

import model.Employee;
import java.util.ArrayList;

public interface IEmployeeDAO {
    void create(Employee employee) throws InsertionFailedException, DataRetrievalFailureException; // void? boolean? Employee? with exception?
    void delete(Employee employee) throws DeleteFailedException;
    Employee findById(int id) throws NotFoundException, DataRetrievalFailureException;
    ArrayList<Employee> findAll() throws DataRetrievalFailureException;
    void edit(Employee employee) throws UpdateFailedException;

}
