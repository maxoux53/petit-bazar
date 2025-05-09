package business;

import dataAccess.*;
import exceptions.DAORetrievalFailedException;
import interfaces.CloseDAO;

public class DataInteractionManager {
    private static CloseDAO dao;

    static {
        //dao = DBAccess;
        dao = new EmployeeDBAccess();
    }

    public static void close() throws DAORetrievalFailedException {
        dao.close();
    }
}
