package controller;

import business.EmployeeManager;
import exceptions.HashFailedException;
import exceptions.*;
import model.*;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class EmployeeController extends Controller {

    public static int create(String firstName, String lastName, char[] password, Boolean isActive, String street, String streetNumberAsString, String unitNumberAsString, String roleLabel, String dayAsString, String monthAsString, String yearAsString, String managerIdAsString, String zipCodeAsString, String cityName, String countryName) throws HashFailedException, InsertionFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException {
        return EmployeeManager.create(
                new Employee(
                        firstName,
                        lastName,
                        stringToPassword(password),
                        isActive,
                        street,
                        stringToStreetNumber(streetNumberAsString),
                        stringToUnitNumber(unitNumberAsString),
                        roleLabel,
                        stringToDate(dayAsString, monthAsString, yearAsString),
                        stringToId(managerIdAsString),
                        stringToZipCode(zipCodeAsString),
                        cityName
                ),
                new City(
                        stringToZipCode(zipCodeAsString),
                        cityName,
                        countryName
                )
        );
    }


    public static int remove(String idAsString) throws DeleteFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException {
        return EmployeeManager.remove(stringToId(idAsString));
    }

    public static int update(int id, String firstName, String lastName, char[] password, Boolean isActive, String street, String streetNumberAsString, String unitNumberAsString, String roleLabel, String dayAsString, String monthAsString, String yearAsString, String managerIdAsString, String zipCodeAsString, String cityName, String countryName) throws HashFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException, UpdateFailedException {
        return EmployeeManager.update(
                new Employee(
                        id,
                        firstName,
                        lastName,
                        stringToPassword(password),
                        isActive,
                        street,
                        stringToStreetNumber(streetNumberAsString),
                        stringToUnitNumber(unitNumberAsString),
                        roleLabel,
                        stringToDate(dayAsString, monthAsString, yearAsString),
                        stringToId(managerIdAsString),
                        stringToZipCode(zipCodeAsString),
                        cityName
                ),
                new City(
                        stringToZipCode(zipCodeAsString),
                        cityName,
                        countryName
                )
        );
    }

    private static Integer stringToStreetNumber(String streetNumberAsString) throws ProhibitedValueException, WrongTypeException {
        if (!streetNumberAsString.isEmpty()) {
            int streetNumber;

            try {
                streetNumber = Integer.parseInt(streetNumberAsString);

                if (streetNumber < 0) {
                    throw new ProhibitedValueException("Numéro de rue");
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Numéro de rue");
            }
        }
        return null;
    }

    private static Integer stringToUnitNumber(String unitNumberAsString) throws ProhibitedValueException, WrongTypeException {
        if (!unitNumberAsString.isEmpty()) {
            int unitNumber;

            try {
                unitNumber = Integer.parseInt(unitNumberAsString);

                if (unitNumber < 0) {
                    throw new ProhibitedValueException("Numéro d'unité");
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Numéro d'unité");
            }
            return unitNumber;
        }
        return null;
    }

    private static byte[] stringToPassword(char[] password) throws HashFailedException {
        if (password != null) {
            return EmployeeManager.hashPassword(new String(password));
        }
        return null;
    }

    private static Integer stringToId(String idAsString) throws ProhibitedValueException, WrongTypeException {
        if (!idAsString.isEmpty()) {
            try {
                return Integer.parseInt(idAsString);
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Identifiant");
            }
        }
        return null;
    }

    private static Integer stringToZipCode(String zipCodeAsString) throws ProhibitedValueException, WrongTypeException {
        if (!zipCodeAsString.isEmpty()) {
            int zipCode;

            try {
                zipCode = Integer.parseInt(zipCodeAsString);

                if (zipCode < 0) {
                    throw new ProhibitedValueException("Code postal");
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Code postal");
            }
        }
        return null;
    }

    public static EmployeeInfoWrapper[] getEmployeeById(String idAsString) throws NotFoundException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException {
        return EmployeeManager.getById(stringToId(idAsString));
    }

    public static ArrayList<Employee> getAllEmployees() throws DAORetrievalFailedException {
        return EmployeeManager.getAll();
    }

    public static boolean isPasswordCorrect(String username, char[] passwordAttempt) throws HashFailedException, DAORetrievalFailedException, NotFoundException {
        return EmployeeManager.checkPassword(passwordAttempt, Integer.parseInt(username));
    }

    public static ArrayList<String> getAllCountries() throws DAORetrievalFailedException {
        return EmployeeManager.getAllCountries();
    }

    public static ArrayList<String> getAllRoles() throws DAORetrievalFailedException {
        return EmployeeManager.getAllRoles();
    }

    public static DefaultTableModel infoTableModel() throws DAORetrievalFailedException {
        String[] ColumnNames = {
                "Matricule",
                "Prénom",
                "Nom",
                "est actif",
                "Rue",
                "Numéro de rue",
                "Numéro de boîte",
                "Rôle",
                "Date d'embauche",
                "Identifiant du manager",
                "Code postal de la ville",
                "Nom de la ville"
        };

        DefaultTableModel model = new DefaultTableModel(ColumnNames, 0);

        ArrayList<Employee> employees = getAllEmployees();
        String[] employeeInfos = new String[ColumnNames.length];
        
        for (Employee employee : employees) {
            
            employeeInfos[0] = String.valueOf(employee.getId());
            employeeInfos[1] = employee.getFirstName();
            employeeInfos[2] = employee.getLastName();
            employeeInfos[3] = (employee.getActive() ? "Oui" : "Non");
            employeeInfos[4] = employee.getStreet();
            employeeInfos[5] = String.valueOf(employee.getStreetNumber());
            employeeInfos[6] = String.valueOf(employee.getUnitNumber());
            employeeInfos[7] = employee.getRoleLabel();
            employeeInfos[8] = employee.getHireDate().getDayOfMonth() + "/" + employee.getHireDate().getMonth() + "/" + employee.getHireDate().getYear();
            employeeInfos[9] = String.valueOf(employee.getManagerId());
            employeeInfos[10] = String.valueOf(employee.getCityZipCode());
            employeeInfos[11] = employee.getCityName();
            
            model.addRow(employeeInfos);
        }

        return model;
    }
}
