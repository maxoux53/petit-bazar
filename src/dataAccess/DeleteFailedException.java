package dataAccess;

public class DeleteFailedException extends DAOOperationFailedException {
    public DeleteFailedException(String message) {
        super("Object deletion failed: " + message);
    }
}
