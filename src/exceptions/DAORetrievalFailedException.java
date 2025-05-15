package exceptions;

public class DAORetrievalFailedException extends Exception {
    private String additionalContext;

    public DAORetrievalFailedException(String additionalContext, String message) {
        super(message);
        this.additionalContext = additionalContext;
    }

    @Override
    public String getMessage() {
        return additionalContext + "\nVoir: " + super.getMessage();
    }
}
