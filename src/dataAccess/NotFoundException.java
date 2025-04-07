package dataAccess;

public class NotFoundException extends DAOOperationFailedException {
    public NotFoundException(String message) {
        super("Object retrieval failed: " + message);
    }
}
