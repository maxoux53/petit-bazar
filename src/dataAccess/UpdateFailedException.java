package dataAccess;

public class UpdateFailedException extends DAOOperationFailedException {
    public UpdateFailedException(String objectType, int objectId, String message) {
        super("update", objectType, objectId, message);
    }
}
