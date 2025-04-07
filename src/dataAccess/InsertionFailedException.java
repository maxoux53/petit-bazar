package dataAccess;

public class InsertionFailedException extends DAOOperationFailedException {
    public InsertionFailedException(String message) {
        super("Object addition failed: " + message);
    }
}
