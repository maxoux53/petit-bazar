package controller;

public class FieldIsEmpty extends Exception {

    public FieldIsEmpty(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Le champ suivant est vide : " + super.getMessage();
    }
}
