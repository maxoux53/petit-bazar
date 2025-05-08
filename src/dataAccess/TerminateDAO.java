package dataAccess;

import exceptions.DAORetrievalFailedException;

public interface TerminateDAO {
    void close() throws DAORetrievalFailedException;
}
