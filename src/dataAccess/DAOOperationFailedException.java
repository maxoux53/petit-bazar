package dataAccess;

public abstract class DAOOperationFailedException extends Exception {
    private String objectType;
    private Long objectId;
    private String operationType;

    public DAOOperationFailedException(String operationType, String objectType, Long objectId, String message) {
        super(message);
        this.operationType = operationType;
        this.objectType = objectType;
        this.objectId = objectId;
    }

    public String customMessage() {
        if (operationType == null) {
            return "L'opération a échoué !";
        } else {
            return "L'opération de " + operationType + " sur l'objet " + objectType + ((objectType != null) ? " dont l'identifiant est '" + objectId + "'" : "") + " a échoué !";
        }
    }

    @Override
    public String getMessage() {
        return customMessage() + " Voir : " + super.getMessage();
    }
}
