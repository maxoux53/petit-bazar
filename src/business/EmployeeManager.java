package business;

import dataAccess.*;
import model.Employee;
import java.security.MessageDigest;
import java.util.ArrayList;

public class EmployeeManager {                           // static?
    private static IEmployeeDAO dao;
    private static MessageDigest digest;

    static {
        dao = new EmployeeDBAccess();
    }

    public static void add(Employee employee) throws InsertionFailedException, DAORetrievalFailedException {
        dao.create(employee);
    }

    public static void remove(int id) throws DeleteFailedException, DAORetrievalFailedException {
        dao.deleteById(id);                                          // todo: handle returned int
    }

    public static Employee getById(int id) throws NotFoundException, DAORetrievalFailedException {
        return dao.findById(id);
    }

    public static ArrayList<Employee> getAll() throws DAORetrievalFailedException {
        return dao.findAll();
    }

    public static void update(Employee employee) throws UpdateFailedException, DAORetrievalFailedException {
        dao.edit(employee);
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

    public static boolean checkPassword(String passwordAttempt, int id) throws HashFailedException, NotFoundException, DAORetrievalFailedException {
        return MessageDigest.isEqual(
                hashPassword(passwordAttempt),
                dao.getPasswordHash(id)
        );
    }
}
