package businessPackage;

import dataAccessPackage.employee.EmployeeDBAccess;
import dataAccessPackage.employee.IEmployeeDAO;
import modelPackage.Employee;

import java.util.ArrayList;

public class EmployeeManager { // PENSER A GERER LES EXCEPTIONS !!!
    private IEmployeeDAO dao;

    public EmployeeManager() {
        setDao(new EmployeeDBAccess());
    }

    public void setDao(IEmployeeDAO dao) {
        this.dao = dao;
    }

    // CRUD

    public void addEmployee(Employee employee) {
        dao.addEmployee(employee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public Employee getEmployeeById(String id) {
        return dao.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee) {
        dao.updateEmployee(employee);
    }

    public void deleteEmployee(String id) {
        dao.deleteEmployee(id);
    }
}
