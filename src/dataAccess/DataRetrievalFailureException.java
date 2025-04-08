package dataAccess;

public class DataRetrievalFailureException extends DAOOperationFailedException {
    public DataRetrievalFailureException(String message) {
        super(message);
    }
}
