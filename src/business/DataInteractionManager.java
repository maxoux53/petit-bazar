package business;

import dataAccess.*;
import exceptions.DAORetrievalFailedException;
import interfaces.CloseDAO;

public class DataInteractionManager {
    private CloseDAO dao;

    public DataInteractionManager() {
        setDao(new EmployeeDBAccess());
    }

    public void setDao(CloseDAO dao) {
        this.dao = dao;
    }

    public void close() throws DAORetrievalFailedException {
        dao.close();
    }
}
