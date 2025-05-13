package business;

import dataAccess.*;
import dataAccess.employee.EmployeeDBAccess;
import exceptions.DAORetrievalFailedException;

public class DataInteractionManager {
    private static ICloseDAO dao;

    static {
        //dao = DBAccess;
        dao = new EmployeeDBAccess();
    }

    public static void close() throws DAORetrievalFailedException {
        dao.close();
    }
}
