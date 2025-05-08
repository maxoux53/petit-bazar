package dataAccess;

import exceptions.DAORetrievalFailedException;

public interface ITerminateDAO {
    void close() throws DAORetrievalFailedException;
}
