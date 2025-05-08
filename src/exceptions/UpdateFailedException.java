package exceptions;

public class UpdateFailedException extends DAOOperationFailedException {
    public UpdateFailedException(String objectType, Long objectId, String message) {
        super("mise-à-jour", objectType, objectId, message);
    }
}
