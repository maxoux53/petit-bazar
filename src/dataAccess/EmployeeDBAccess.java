package dataAccess;

import exceptions.*;
import interfaces.EmployeeDAO;
import model.City;
import model.Employee;
import model.EmployeePlace;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDBAccess extends DBAccess implements EmployeeDAO {
    private static final String objectClassName;

    static {
        objectClassName = Employee.class.getSimpleName().toLowerCase();
    }
    
    // Public methods

    public void create(Employee employee) throws InsertionFailedException, DAORetrievalFailedException {
        sqlInstruction = "INSERT INTO employee (first_name, last_name, password, is_active, street, street_number, unit_number, role_label, hire_date, manager_id, city_zip_code, city_name) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
        
        setValues(employee, sqlInstruction);
        
        try {
            preparedStatement.executeUpdate();
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new InsertionFailedException(objectClassName, (Integer)null, e.getMessage());
        }
    }

    public int remove(Integer id) throws DeleteFailedException, DAORetrievalFailedException {
        nullifyEmployeeReferencesFromPurchases(id);
        nullifyEmployeeReferencedAsManager(id);

        sqlInstruction = "DELETE FROM employee WHERE id = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, id);

            try {
                return preparedStatement.executeUpdate();
            } catch (SQLTimeoutException e) {
                throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
            } catch (SQLException e) {
                throw new DeleteFailedException(objectClassName, id, e.getMessage());
            }

        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    private void nullifyEmployeeReferencesFromPurchases(Integer employeeId) throws DAORetrievalFailedException {
        sqlInstruction = "UPDATE purchase SET employee_id = NULL WHERE employee_id = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    private void nullifyEmployeeReferencedAsManager(Integer employeeId) throws DAORetrievalFailedException {
        sqlInstruction = "UPDATE employee SET manager_id = NULL WHERE manager_id = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    public int update(Employee employee) throws UpdateFailedException, DAORetrievalFailedException {
        sqlInstruction = "UPDATE employee SET first_name = ?, last_name = ?, password = ?, is_active = ?, street = ?, street_number = ?, unit_number = ?, role_label = ?, hire_date = ?, manager_id = ?, city_zip_code = ?, city_name = ? WHERE id = ?;";

        setValues(employee, sqlInstruction);
        
        try {
            preparedStatement.setInt(13, employee.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new UpdateFailedException(objectClassName, employee.getId(), e.getMessage());
        }
    }

    public Employee getById(Integer id) throws NotFoundException, DAORetrievalFailedException, ProhibitedValueException {
        sqlInstruction = "SELECT * FROM employee WHERE id = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, id);

            ResultSet data = preparedStatement.executeQuery();

            if (data.next()) {
                return resultSetToEmployee(data);
            } else {
                throw new NotFoundException(objectClassName, id, DBRetrievalFailure.NO_ROW);
            }
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    public ArrayList<Employee> getAll() throws DAORetrievalFailedException, ProhibitedValueException {
        sqlInstruction = "SELECT * FROM employee;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<Employee> employeesInfos = new ArrayList<>();
            while (data.next()) {
                employeesInfos.add(resultSetToEmployee(data));
            }

            return employeesInfos;
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    public byte[] getPasswordHash(Integer id) throws NotFoundException, DAORetrievalFailedException {
        sqlInstruction = "SELECT password FROM employee WHERE id = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, id);

            ResultSet data = preparedStatement.executeQuery();

            if (data.next()) {
                return data.getBytes("password");
            } else {
                throw new NotFoundException("password", id, DBRetrievalFailure.NO_ROW);
            }
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    public void setCity(City city) throws DAORetrievalFailedException {
        String cityName = city.getName();
        Integer cityZipCode = city.getZipCode();

        sqlInstruction = "SELECT * FROM city WHERE zip_code = ? AND name = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, cityZipCode);
            preparedStatement.setString(2, cityName);
            

            ResultSet data = preparedStatement.executeQuery();

            if (!data.next()) {
                sqlInstruction = "INSERT INTO city VALUES(?, ?, ?);";

                preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
                preparedStatement.setInt(1, cityZipCode);
                preparedStatement.setString(2, cityName);
                preparedStatement.setString(3, city.getCountry());
                preparedStatement.executeUpdate();
            }

        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    public City getCity(Integer zipCode, String name) throws DAORetrievalFailedException, NotFoundException, ProhibitedValueException {
        sqlInstruction = "SELECT * FROM city WHERE zip_code = ? AND name = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, zipCode);
            preparedStatement.setString(2, name);

            ResultSet data = preparedStatement.executeQuery();

            if (data.next()) {
                return new City(zipCode, name, data.getString("country"));
            } else {
                throw new NotFoundException(City.class.getSimpleName().toLowerCase(), zipCode, DBRetrievalFailure.NO_ROW);
            }
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    public ArrayList<String> getAllCountries() throws DAORetrievalFailedException {
        sqlInstruction = "SELECT name FROM country;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<String> countries = new ArrayList<>();

            while (data.next()) {
                countries.add(data.getString("name"));
            }

            return countries;
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }

    public ArrayList<String> getAllRoles() throws DAORetrievalFailedException {
        sqlInstruction = "SELECT label FROM role;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<String> roles = new ArrayList<>();

            while (data.next()) {
                roles.add(data.getString("label"));
            }

            return roles;
        } catch (SQLTimeoutException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, e.getMessage());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }
    
    // Research
    
    public ArrayList<EmployeePlace> getEmployeePlaceByEmployee(int employeeId) throws ProhibitedValueException, DAORetrievalFailedException {
        sqlInstruction = "SELECT employee.first_name AS employee_first_name, employee.last_name AS employee_last_name, city.name AS city_name, city.zip_code AS city_zip_code, country.name AS country_name " +
                "FROM employee " +
                "INNER JOIN city ON employee.city_name = city.name AND employee.city_zip_code = city.zip_code " +
                "INNER JOIN country ON city.country = country.name " +
                "WHERE employee.id = ?;";

        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            preparedStatement.setInt(1, employeeId);

            ResultSet data = preparedStatement.executeQuery();

            ArrayList<EmployeePlace> employeePlaces = new ArrayList<>();

            if (data.next()) {
                try {
                    employeePlaces.add(new EmployeePlace(
                                    data.getString("employee_first_name"),
                                    data.getString("employee_last_name"),
                                    data.getString("city_name"),
                                    data.getInt("city_zip_code"),
                                    data.getString("country_name")
                            )
                    );
                } catch (ProhibitedValueException e) {
                    throw new ProhibitedValueException("Valeur interdite !");
                }

            }

            return employeePlaces;

        } catch (SQLTimeoutException exception) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.TIMEOUT, exception.getMessage());
        } catch (SQLException exception) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, exception.getMessage());
        }
    }
    
    // Private methods

    private Employee resultSetToEmployee(ResultSet data) throws DAORetrievalFailedException, ProhibitedValueException {
        Employee employee;
        int unitNumber;
        int managerId;

        try {
            employee = new Employee(
                    data.getInt("id"),
                    data.getString("first_name"),
                    data.getString("last_name"),
                    data.getBytes("password"),
                    data.getBoolean("is_active"),
                    data.getString("street"),
                    data.getString("street_number"),
                    data.getString("role_label"),
                    data.getDate("hire_date").toLocalDate(),
                    data.getInt("city_zip_code"),
                    data.getString("city_name")
            );

            unitNumber = data.getInt("unit_number");
            if (!data.wasNull()) {
                employee.setUnitNumber(unitNumber);
            }

            managerId = data.getInt("manager_id");
            if (!data.wasNull()) {
                employee.setManagerId(managerId);
            }
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }

        return employee;
    }
    
    private void setValues(Employee employee, String sqlInstruction) throws DAORetrievalFailedException {
        try {
            preparedStatement = SingletonConnection.getInstance().prepareStatement(sqlInstruction);
            
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setBytes(3, employee.getPassword());
            preparedStatement.setBoolean(4, employee.getActive());
            preparedStatement.setString(5, employee.getStreet());
            preparedStatement.setString(6, employee.getStreetNumber());

            if (employee.getUnitNumber() == null) {
                preparedStatement.setNull(7, Types.INTEGER);
            } else {
                preparedStatement.setInt(7, employee.getUnitNumber());
            }

            preparedStatement.setString(8, employee.getRoleLabel());
            preparedStatement.setDate(9, Date.valueOf(employee.getHireDate()));

            if (employee.getManagerId() == null) {
                preparedStatement.setNull(10, Types.INTEGER);
            } else {
                preparedStatement.setInt(10, employee.getManagerId());
            }

            preparedStatement.setInt(11, employee.getCityZipCode());
            preparedStatement.setString(12, employee.getCityName());
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.ACCESS_ERROR, e.getMessage());
        }
    }
}

