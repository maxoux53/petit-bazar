package businessPackage;

import dataAccessPackage.employee.EmployeeDBAccess;
import dataAccessPackage.employee.IEmployeeDAO;
import exceptionPackage.ConnectionException;
import exceptionPackage.ExistingException;
import exceptionPackage.NotFoundException;
import modelPackage.Employee;

import java.util.ArrayList;

public class EmployeeManager {
    private IEmployeeDAO dao;

    public EmployeeManager() {
        setDao(new EmployeeDBAccess());
    }

    public void setDao(IEmployeeDAO dao) {
        this.dao = dao;
    }

    // CRUD

    public void addEmployee(Employee employee) throws ConnectionException, ExistingException {
        dao.addEmployee(employee);
    }

    public ArrayList<Employee> getAllEmployees() throws ConnectionException, NotFoundException {
        return dao.getAllEmployees();
    }

    public Employee getEmployeeById(String id) throws ConnectionException, NotFoundException {
        return dao.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee) throws ConnectionException, NotFoundException {
        dao.updateEmployee(employee);
    }

    public void deleteEmployee(String id) throws ConnectionException, NotFoundException {
        dao.deleteEmployee(id);
    }
}
