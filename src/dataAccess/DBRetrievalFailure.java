package dataAccess;

public enum DBRetrievalFailure {
    TIMEOUT("La requête a pris trop de temps à s'exécuter"),
    ACCESS_ERROR("L'accès SQL a échoué"),
    NO_ROW("Aucune donnée disponible"),
    CLOSURE_ERROR("Des erreurs se sont produites lors de la fermeture de la connexion");

    private String text;

    DBRetrievalFailure(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text + "!";
    }
}
