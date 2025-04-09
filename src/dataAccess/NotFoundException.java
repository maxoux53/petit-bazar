package dataAccess;

public class NotFoundException extends DAOOperationFailedException {
    public NotFoundException(String objectType, int objectId, String message) {
        super("research", objectType, objectId, message); // vocab
    }
}
