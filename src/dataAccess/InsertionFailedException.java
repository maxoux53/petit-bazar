package dataAccess;

public class InsertionFailedException extends DAOOperationFailedException {
    public InsertionFailedException(String objectType, long objectId, String message) {
        super("insertion", objectType, objectId, message);
    }
}
