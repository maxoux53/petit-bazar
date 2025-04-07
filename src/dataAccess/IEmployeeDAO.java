package dataAccess;

import model.Employee;
import java.util.ArrayList;

public interface IEmployeeDAO {
    void create(Employee employee) throws InsertionFailedException; // void? boolean? Employee? with exception?
    void delete(Employee employee) throws DeleteFailedException;
    Employee findById(int id) throws NotFoundException;
    ArrayList<Employee> findAll() throws NotFoundException;
    void edit(Employee employee) throws UpdateFailedException;

}
