package dataAccess;

import exceptions.DAORetrievalFailedException;

public interface ICloseDAO {
    void close() throws DAORetrievalFailedException;
}
