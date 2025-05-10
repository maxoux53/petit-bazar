package business;

import dataAccess.*;
import exceptions.DAORetrievalFailedException;
import interfaces.CloseDAO;

public class DataInteractionManager {
    private CloseDAO dao;

    public DataInteractionManager() {
        //dao = DBAccess;
        dao = new EmployeeDBAccess();
    }

    public void close() throws DAORetrievalFailedException {
        dao.close();
    }
}
