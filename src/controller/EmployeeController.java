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

    public static int edit(int id, String firstName, String lastName, char[] password, Boolean isActive, String street, String streetNumberAsString, String unitNumberAsString, String roleLabel, String dayAsString, String monthAsString, String yearAsString, String managerIdAsString, String zipCodeAsString, String cityName, String countryName) throws HashFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException, UpdateFailedException {
        return EmployeeManager.edit(
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

    public static IEmployeeInfoWrapper[] getEmployeeById(String idAsString) throws NotFoundException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException {
        return EmployeeManager.getById(stringToId(idAsString));
    }

    public static ArrayList<IEmployeeInfoWrapper[]> getAllEmployees() throws DAORetrievalFailedException {
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
        String[] nomColonnes = {
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

        DefaultTableModel modele = new DefaultTableModel(nomColonnes, 0);

        ArrayList<IEmployeeInfoWrapper[]> employeesInfo = getAllEmployees();
        Employee employee;
        City city;
        Object[] ligne = new Object[nomColonnes.length];

        for (IEmployeeInfoWrapper[] employeeInfo : employeesInfo) {
            employee = (Employee)employeeInfo[0];
            city = (City)employeeInfo[1];

            ligne[0] = employee.getId();
            ligne[1] = employee.getFirstName();
            ligne[2] = employee.getLastName();
            ligne[3] = employee.getActive();
            ligne[4] = employee.getStreet();
            ligne[5] = employee.getStreetNumber();
            ligne[6] = employee.getUnitNumber();
            ligne[7] = employee.getRoleLabel();
            ligne[8] = employee.getHireDate();
            ligne[9] = employee.getManagerId();
            ligne[10] = city.getZipCode();
            ligne[11] = city.getName();

            modele.addRow(ligne);
        }

        return modele;
    }
}
