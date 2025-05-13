package dataAccess;

import exceptions.DAORetrievalFailedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DBAccess implements ICloseDAO {
    /*package-protected*/ String sqlInstruction;
    /*package-protected*/ PreparedStatement preparedStatement;
    /*package-protected*/ ResultSet data;

    public void close() throws DAORetrievalFailedException {
        try {
            SingletonConnection.getInstance().close();
        } catch (SQLException e) {
            throw new DAORetrievalFailedException(DBRetrievalFailure.CLOSURE_ERROR.toString(), e.getMessage());
        }
    }
}
