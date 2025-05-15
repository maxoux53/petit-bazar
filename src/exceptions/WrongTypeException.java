package exceptions;

public class WrongTypeException extends Exception {

    public WrongTypeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Erreur de conversion pour le champ suivant : " + super.getMessage();
    }
}
