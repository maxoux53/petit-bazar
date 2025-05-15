package exceptions;

public class ProhibitedValueException extends Exception {
    public ProhibitedValueException(String customMessage) {
        super("Valeur interdite pour ce champ :\n" + customMessage);
    }
}
