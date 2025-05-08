package exceptions;

public class DeleteFailedException extends DAOOperationFailedException {
    public DeleteFailedException(String objectType, Long objectId, String message) {
        super("suppression", objectType, objectId, message);
    }
}
