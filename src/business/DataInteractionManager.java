package business;

import dataAccess.*;
import dataAccess.employee.EmployeeDBAccess;
import exceptions.DAORetrievalFailedException;

public class DataInteractionManager {
    private ICloseDAO dao;

    public DataInteractionManager() {
        setDao(new EmployeeDBAccess()); //A VERIFIER
    }

    public void setDao(ICloseDAO dao) {
        this.dao = dao;
    }

    public void close() throws DAORetrievalFailedException {
        dao.close();
    }
}
