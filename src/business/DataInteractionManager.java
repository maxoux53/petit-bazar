package business;

import dataAccess.*;

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
