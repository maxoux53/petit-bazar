package dataAccess;

public class SQLConnectionException extends DAOOperationFailedException {
    public SQLConnectionException(String message) {
        super("SQL connection to database failed, see: " + message);
    }
}
