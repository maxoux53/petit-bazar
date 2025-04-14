package dataAccess;

public class DeleteFailedException extends DAOOperationFailedException {
    public DeleteFailedException(String objectType, int objectId, String message) {
        super("deletion", objectType, objectId, message);
    }
}
