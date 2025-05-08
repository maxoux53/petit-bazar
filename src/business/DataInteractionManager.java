package business;

import dataAccess.*;
import exceptions.DAORetrievalFailedException;

public class DataInteractionManager {
    private static ITerminateDAO dao;

    static {
        //dao = DBAccess;
        dao = new EmployeeDBAccess();
    }

    public static void terminate() throws DAORetrievalFailedException {
        dao.close();
    }
}
