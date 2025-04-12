package dataAccess;

public enum DBRetrievalFailure {
    TIMEOUT("Database query timed out"),
    ACCESS_ERROR("SQL data access failed"),
    NO_ROW("There are no more rows");

    private String text;

    DBRetrievalFailure(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text + "!";
    }
}
