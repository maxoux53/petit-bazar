package controller;

public class WrongType extends Exception {

    public WrongType(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Erreur de type dans le champ suivant : " + super.getMessage();
    }
}
