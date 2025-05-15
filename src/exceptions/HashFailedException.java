package exceptions;

public class HashFailedException extends Exception {
    public HashFailedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Échec lors du traitement du mot de passe avec l'algorithme de hachage !\nVoir: " + super.getMessage();
    }
}
