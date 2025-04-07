package dataAccess;

public class UpdateFailedException extends DAOOperationFailedException {
    public UpdateFailedException(String message) {
        super("Object edition failed: " + message);
    }
}
