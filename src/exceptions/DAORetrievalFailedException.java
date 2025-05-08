package exceptions;

public class DAORetrievalFailedException extends Exception {
    private String additionalContext;

    public DAORetrievalFailedException(String additionalContext, String message) {
        super(message);
        this.additionalContext = additionalContext;
    }

    public DAORetrievalFailedException(String message) {
        this(null, message);
    }

    @Override
    public String getMessage() {
        return (additionalContext != null ? additionalContext + " " : "") + "Voir : " + super.getMessage();
    }
}
