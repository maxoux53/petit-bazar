package view;

public class SleepFaildedException extends RuntimeException {
    public SleepFaildedException(String message) {
        super(message);
    }
    
    public String customMessage() {
      return "Le temps d'attente de l'animation du chariot a échoué, l'erreur :";
    }

  @Override
  public String getMessage() {
    return customMessage() + " " + super.getMessage();
  }
}
