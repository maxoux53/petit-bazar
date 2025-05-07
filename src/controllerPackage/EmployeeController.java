package controllerPackage;

import exceptionPackage.*;
import modelPackage.Employee;
import businessPackage.EmployeeManager;

import java.util.ArrayList;

public class EmployeeController {
    private EmployeeManager employeeManager;

    public EmployeeController() {
        employeeManager = new EmployeeManager();
    }

    public void addEmployee(Employee employee) throws ConnectionException, ExistingException {
        employeeManager.addEmployee(employee);
    }

    public ArrayList<Employee> getAllEmployees() throws ConnectionException, NotFoundException {
        return employeeManager.getAllEmployees();
    }

    public Employee getEmployeeById(String id) throws ConnectionException, NotFoundException {
        return employeeManager.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee) throws ConnectionException, NotFoundException {
        employeeManager.updateEmployee(employee);
    }

    public void deleteEmployee(String id) throws ConnectionException, NotFoundException {
        employeeManager.deleteEmployee(id);
    }
}
