package controller;

import business.EmployeeManager;
import business.HashFailedException;
import dataAccess.*;
import model.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeController {

    public static IEmployeeInfoWrapper[] getEmployeeById(int id) throws NotFoundException, DAORetrievalFailedException {
        return EmployeeManager.getById(id);
    }

    public static ArrayList<String> getCountries() throws DAORetrievalFailedException {
        return EmployeeManager.getAllCountries();
    }

    public static void createEmployee(String firstName, String lastName, char[] password, Boolean isActive, String street, String streetNumberAsString, String unitNumberAsString, String roleLabel, String dayAsString, String monthAsString, String yearAsString, String managerIdAsString, String zipCodeAsString, String cityName, String countryName) throws HashFailedException, InsertionFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException {
        byte[] passwordHash = null;
        Integer streetNumber = null;
        Integer unitNumber = null;
        LocalDate hireDate;
        Integer managerId = null;
        Integer zipCode = null;

        // Password
        if (password != null) {
            passwordHash = EmployeeManager.hashPassword(new String(password));
        }

        // Street number
        if (!streetNumberAsString.isEmpty()) {
            try {
                streetNumber = Integer.parseInt(streetNumberAsString);

                if (streetNumber < 0) {
                    throw new ProhibitedValueException(streetNumberAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Numéro de rue");
            }
        }

        // Unit number
        if (!unitNumberAsString.isEmpty()) {
            try {
                unitNumber = Integer.parseInt(unitNumberAsString);

                if (unitNumber < 0) {
                    throw new ProhibitedValueException(unitNumberAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Numéro d'unité");
            }
        }

        // Hire date
        int day;
        try {
            day = Integer.parseInt(dayAsString);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Jour");
        }

        int month;
        try {
            month = Integer.parseInt(monthAsString);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Mois");
        }

        int year;
        try {
            year = Integer.parseInt(yearAsString);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Année");
        }

        try {
            hireDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new ProhibitedValueException(day + "/" + month + "/" + year);
        }

        // Manager ID
        if (!managerIdAsString.isEmpty()) {
            try {
                managerId = Integer.parseInt(managerIdAsString);

                if (managerId < 0) {
                    throw new ProhibitedValueException(managerIdAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Identifiant du gérant");
            }
        }

        // Zip code
        if (!zipCodeAsString.isEmpty()) {
            try {
                zipCode = Integer.parseInt(zipCodeAsString);

                if (zipCode < 0) {
                    throw new ProhibitedValueException(zipCodeAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Code postal");
            }
        }



        EmployeeManager.add(
                new Employee(firstName, lastName, passwordHash, isActive, street, streetNumber, unitNumber, roleLabel, hireDate, managerId, zipCode, cityName),
                new City(zipCode, cityName, countryName)
        );
    }

    public static void removeEmployee(int id) throws DeleteFailedException, DAORetrievalFailedException {
        EmployeeManager.remove(id);
    }

    public static ArrayList<IEmployeeInfoWrapper[]> getAllEmployees() throws DAORetrievalFailedException {
        return EmployeeManager.getAll();
    }

    public static void updateEmployee(int id, String firstName, String lastName, char[] password, Boolean isActive, String street, String streetNumberAsString, String unitNumberAsString, String roleLabel, String dayAsString, String monthAsString, String yearAsString, String managerIdAsString, String zipCodeAsString, String cityName, String countryName) throws HashFailedException, DAORetrievalFailedException, WrongTypeException, ProhibitedValueException, UpdateFailedException {
        byte[] passwordHash = null;
        Integer streetNumber = null;
        Integer unitNumber = null;
        LocalDate hireDate;
        Integer managerId = null;
        Integer zipCode = null;

        // Password
        if (password != null) {
            passwordHash = EmployeeManager.hashPassword(new String(password));
        }

        // Street number
        if (!streetNumberAsString.isEmpty()) {
            try {
                streetNumber = Integer.parseInt(streetNumberAsString);

                if (streetNumber < 0) {
                    throw new ProhibitedValueException(streetNumberAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Numéro de rue");
            }
        }

        // Unit number
        if (!unitNumberAsString.isEmpty()) {
            try {
                unitNumber = Integer.parseInt(unitNumberAsString);

                if (unitNumber < 0) {
                    throw new ProhibitedValueException(unitNumberAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Numéro d'unité");
            }
        }

        // Hire date
        int day;
        try {
            day = Integer.parseInt(dayAsString);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Jour");
        }

        int month;
        try {
            month = Integer.parseInt(monthAsString);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Mois");
        }

        int year;
        try {
            year = Integer.parseInt(yearAsString);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeException("Année");
        }

        try {
            hireDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new ProhibitedValueException(day + "/" + month + "/" + year);
        }

        // Manager ID
        if (!managerIdAsString.isEmpty()) {
            try {
                managerId = Integer.parseInt(managerIdAsString);

                if (managerId < 0) {
                    throw new ProhibitedValueException(managerIdAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Identifiant du gérant");
            }
        }

        // Zip code
        if (!zipCodeAsString.isEmpty()) {
            try {
                zipCode = Integer.parseInt(zipCodeAsString);

                if (zipCode < 0) {
                    throw new ProhibitedValueException(zipCodeAsString);
                }
            } catch (NumberFormatException numberFormatException) {
                throw new WrongTypeException("Code postal");
            }
        }



        EmployeeManager.update(
                new Employee(id, firstName, lastName, passwordHash, isActive, street, streetNumber, unitNumber, roleLabel, hireDate, managerId, zipCode, cityName),
                new City(zipCode, cityName, countryName)
        );
    }


    public static boolean employeeLogin(String username, char[] passwordAttempt) throws HashFailedException, DAORetrievalFailedException, NotFoundException {
        return EmployeeManager.checkPassword(passwordAttempt, Integer.parseInt(username));
    }

}
