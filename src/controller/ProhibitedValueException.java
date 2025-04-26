package controller;

public class ProhibitedValueException extends Exception {
    private String value;

    public ProhibitedValueException(String value) {
        super("message"); // message MUST BE CHANGED!! ⚠️
    }
}
