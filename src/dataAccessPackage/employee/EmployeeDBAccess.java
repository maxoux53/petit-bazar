package dataAccessPackage.employee;

import dataAccessPackage.SingletonConnection;
import exceptionPackage.*;
import modelPackage.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeDBAccess implements IEmployeeDAO {

    @Override
    public void addEmployee(Employee employee) throws ConnectionException, ExistingException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "INSERT INTO pb.employee (id, firstName, lastName, password, isActive, street, streetNumber, unitNumber, hireDate, idRole, idManager, idCity) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setBytes(4, employee.getPassword());
            ps.setBoolean(5, employee.isActive());
            ps.setString(6, employee.getStreet());
            ps.setInt(7, employee.getStreetNumber());
            ps.setInt(8, employee.getUnitNumber());
            ps.setDate(9, new java.sql.Date(employee.getHireDate().getTime()));
            ps.setString(10, employee.getIdRole());
            ps.setString(11, employee.getIdManager());
            ps.setString(12, employee.getIdCity());

            ps.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                throw new ExistingException("Erreur : cet employé existe déjà");
            } else {
                throw new ConnectionException("Erreur lors de l'ajout de l'employé");
            }
        }
    }

    @Override
    public ArrayList<Employee> getAllEmployees() throws ConnectionException, NotFoundException {
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "SELECT * FROM pb.employee";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getString("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPassword(rs.getBytes("password"));
                employee.setActive(rs.getBoolean("isActive"));
                employee.setStreet(rs.getString("street"));
                employee.setStreetNumber(rs.getInt("streetNumber"));
                employee.setUnitNumber(rs.getInt("unitNumber"));
                employee.setHireDate(new Date(rs.getDate("hireDate").getTime()));
                employee.setIdRole(rs.getString("idRole"));
                employee.setIdManager(rs.getString("idManager"));
                employee.setIdCity(rs.getString("idCity"));

                employees.add(employee);
            }

            if (employees.isEmpty()) {
                throw new NotFoundException("Erreur : aucun employé enregistré");
            }

            return employees;
        } catch (SQLException e) {
            throw new ConnectionException("Erreur lors de la récupération des employés");
        }
    }

    @Override
    public Employee getEmployeeById(String id) throws ConnectionException, NotFoundException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "SELECT * FROM pb.employee WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getString("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setPassword(rs.getBytes("password"));
                employee.setActive(rs.getBoolean("isActive"));
                employee.setStreet(rs.getString("street"));
                employee.setStreetNumber(rs.getInt("streetNumber"));
                employee.setUnitNumber(rs.getInt("unitNumber"));
                employee.setHireDate(new Date(rs.getDate("hireDate").getTime()));
                employee.setIdRole(rs.getString("idRole"));
                employee.setIdManager(rs.getString("idManager"));
                employee.setIdCity(rs.getString("idCity"));

                return employee;
            } else {
                throw new NotFoundException("Erreur : employé introuvable");
            }
        } catch (SQLException e) {
            throw new ConnectionException("Erreur lors de la récupération de l'employé");
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws ConnectionException, NotFoundException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "UPDATE pb.employee SET firstName = ?, lastName = ?, password = ?, isActive = ?, street = ?, " +
                    "streetNumber = ?, unitNumber = ?, hireDate = ?, idRole = ?, idManager = ?, idCity = ? WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setBytes(3, employee.getPassword());
            ps.setBoolean(4, employee.isActive());
            ps.setString(5, employee.getStreet());
            ps.setInt(6, employee.getStreetNumber());
            ps.setInt(7, employee.getUnitNumber());
            ps.setDate(8, new java.sql.Date(employee.getHireDate().getTime()));
            ps.setString(9, employee.getIdRole());
            ps.setString(10, employee.getIdManager());
            ps.setString(11, employee.getIdCity());
            ps.setString(12, employee.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new NotFoundException("Erreur : employé introuvable");
            }
        } catch (SQLException e) {
            throw new ConnectionException("Erreur lors de la mise à jour de l'employé");
        }
    }

    @Override
    public void deleteEmployee(String id) throws ConnectionException, NotFoundException {
        try {
            Connection connection = SingletonConnection.getInstance();
            String sql = "DELETE FROM pb.employee WHERE id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new NotFoundException("Erreur : employé introuvable");
            }
        } catch (SQLException e) {
            throw new ConnectionException("Erreur lors de la suppression de l'employé");
        }
    }
}
