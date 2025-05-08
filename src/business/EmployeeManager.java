package business;

import dataAccess.*;
import exceptions.*;
import model.City;
import model.Employee;
import model.IEmployeeInfoWrapper;

import java.security.MessageDigest;
import java.util.ArrayList;

public class EmployeeManager {
    private static EmployeeDAO dao;
    private static MessageDigest digest;

    static {
        dao = new EmployeeDBAccess();
    }

    public static int create(Employee employee, City city) throws InsertionFailedException, DAORetrievalFailedException {
        return dao.create(employee, city);
    }

    public static int remove(int id) throws DeleteFailedException, DAORetrievalFailedException {
        return dao.delete(id);
    }

    public static int edit(Employee employee, City city) throws UpdateFailedException, DAORetrievalFailedException {
        return dao.update(employee, city);
    }

    public static IEmployeeInfoWrapper[] getById(int id) throws NotFoundException, DAORetrievalFailedException {
        return dao.findById(id);
    }

    public static ArrayList<IEmployeeInfoWrapper[]> getAll() throws DAORetrievalFailedException {
        return dao.findAll();
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

    public static ArrayList<String> getAllCountries() throws DAORetrievalFailedException {
        return dao.getAllCountries();
    }

    public static ArrayList<String> getAllRoles() throws DAORetrievalFailedException {
        return dao.getAllRoles();
    }
}
