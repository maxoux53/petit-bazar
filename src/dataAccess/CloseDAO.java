package dataAccess;

import exceptions.DAORetrievalFailedException;

public interface CloseDAO {
    void close() throws DAORetrievalFailedException;
}
