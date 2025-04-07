package dataAccess;

public abstract class DAOOperationFailedException extends Exception {
    public DAOOperationFailedException(String message) {
        super(message);
    }
}
