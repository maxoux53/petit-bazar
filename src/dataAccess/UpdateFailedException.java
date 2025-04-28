package dataAccess;

public class UpdateFailedException extends DAOOperationFailedException {
    public UpdateFailedException(String objectType, long objectId, String message) {
        super("update", objectType, objectId, message);
    }
}
