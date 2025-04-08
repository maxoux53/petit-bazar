package dataAccess;

public class NotFoundException extends DAOOperationFailedException {
    private String objectType;
    private int objectId;

    public NotFoundException(String objectType, int objectId, String message) {
        super("Object retrieval failed: " + objectType + " with given ID '" + objectId + "' not found. " + message);
    }
}
