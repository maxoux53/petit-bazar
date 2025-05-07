package dataAccessPackage.employee;

import exceptionPackage.*;
import modelPackage.*;

import java.util.ArrayList;

public interface IEmployeeDAO {
    void addEmployee(Employee employee) throws ConnectionException, ExistingException;
    ArrayList<Employee> getAllEmployees() throws ConnectionException, NotFoundException;
    Employee getEmployeeById(String id) throws ConnectionException, NotFoundException;
    void updateEmployee(Employee employee) throws ConnectionException, NotFoundException;
    void deleteEmployee(String id) throws ConnectionException, NotFoundException;
}
