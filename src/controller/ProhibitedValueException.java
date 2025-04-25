package controller;

public class ProhibitedValue extends Exception {
    private String value;

    public ProhibitedValue(String value) {
        super("message"); // message MUST BE CHANGED!! ⚠️
    }
}
