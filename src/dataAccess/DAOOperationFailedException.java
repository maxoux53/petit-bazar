package dataAccess;

public abstract class DAOOperationFailedException extends Exception {
    private String objectType;
    private int objectId;
    private String message;
    private String operationType;

    public DAOOperationFailedException(String operationType, String objectType, int objectId, String message) {
        super(message);
        this.operationType = operationType;
        this.objectType = objectType;
        this.objectId = objectId;
    }

    public String customMessage() {
        if (operationType == null) {
            return "Data operation failed!";
        }
        return "Object " + operationType + " on " + objectType + " with given ID '" + objectId + "failed!";
    }

    @Override
    public String getMessage() {
        return customMessage() + " See: " + super.getMessage();
    }
}
