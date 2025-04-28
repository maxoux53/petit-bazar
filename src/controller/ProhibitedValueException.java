package controller;

public class ProhibitedValueException extends Exception {
    public ProhibitedValueException(String fieldName) {
        super("Prohibited value for field: " + fieldName);
    }
}
