package controller;

public class WrongTypeException extends Exception {

    public WrongTypeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Erreur de type dans le champ suivant : " + super.getMessage();
    }
}
