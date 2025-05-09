package dataAccess;

import exceptions.DAORetrievalFailedException;
import interfaces.CloseDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBAccess implements CloseDAO {
    /*package-protected*/ String sqlInstruction;
    /*package-protected*/ PreparedStatement preparedStatement;

    public void close() throws DAORetrievalFailedException {
        try {
            SingletonConnection.getInstance().close();
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.CLOSURE_ERROR.toString(), e.getMessage());
        }
    }
}
