package business;

import dataAccess.*;
import model.City;
import model.Employee;
import model.IEmployeeInfoWrapper;

import java.security.MessageDigest;
import java.util.ArrayList;

public class EmployeeManager {
    private static IEmployeeDAO dao;
    private static MessageDigest digest;

    static {
        dao = new EmployeeDBAccess();
    }

    public static int add(Employee employee, City city) throws InsertionFailedException, DAORetrievalFailedException {
        return dao.create(employee, city);
    }

    public static void remove(int id) throws DeleteFailedException, DAORetrievalFailedException {
        dao.deleteById(id);
    }

    public static IEmployeeInfoWrapper[] getById(int id) throws NotFoundException, DAORetrievalFailedException {
        return dao.findById(id);
    }

    public static ArrayList<IEmployeeInfoWrapper[]> getAll() throws DAORetrievalFailedException {
        return dao.findAll();
    }

    public static int update(Employee employee, City city) throws UpdateFailedException, DAORetrievalFailedException {
        return dao.edit(employee, city);
    }

    public static byte[] hashPassword(String password) throws HashFailedException {
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (Exception e) {
                throw new HashFailedException(e.getMessage());
            }
        }

        return digest.digest(password.getBytes());
    }

    public static boolean checkPassword(char[] passwordAttempt, int id) throws HashFailedException, NotFoundException, DAORetrievalFailedException {
        return MessageDigest.isEqual(
                hashPassword(new String(passwordAttempt)),
                dao.getPasswordHash(id)
        );
    }

    public static ArrayList<String> getAllRoles() throws DAORetrievalFailedException {
        return dao.getAllRoles();
    }

    public static ArrayList<String> getAllCountries() throws DAORetrievalFailedException {
        return dao.getAllCountries();
    }
}
