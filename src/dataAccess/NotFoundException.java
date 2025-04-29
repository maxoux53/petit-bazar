package dataAccess;

public class NotFoundException extends DAOOperationFailedException {
    public NotFoundException(String objectType, Long objectId, String message) {
        super("consultation", objectType, objectId, message);
    }
}
