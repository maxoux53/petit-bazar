package dataAccess;

public class NotFoundException extends DAOOperationFailedException {
    public NotFoundException(String objectType, int objectId, String message) {
        super("lookup", objectType, objectId, message);
    }
}
