package dataAccess;

public class InsertionFailedException extends DAOOperationFailedException {
    public InsertionFailedException(String objectType, Long objectId, String message) {
        super("insertion", objectType, objectId, message);
    }
}
