package exceptions;

public abstract class DAOOperationFailedException extends Exception {
    private String operationType;
    private String objectType;
    private Long objectId;

    public DAOOperationFailedException(String operationType, String objectType, Long objectId, String message) {
        super(message);
        this.operationType = operationType;
        this.objectType = objectType;
        this.objectId = objectId;
    }

    @Override
    public String getMessage() {
        StringBuilder output = new StringBuilder();

        if (operationType == null) {
            output.append("L'opération a échoué !");
        } else {
            output.append("L'opération de ").append(operationType).append(" sur l'objet ").append(objectType);

            if (objectId != null) {
                output.append(" dont l'identifiant est '").append(objectId).append("'");
            }

            output.append(" a échoué !");
        }

        output.append("\nVoir: ").append(super.getMessage());

        return output.toString();
    }
}
