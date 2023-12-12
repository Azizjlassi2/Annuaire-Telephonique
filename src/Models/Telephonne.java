package Models;

public class Telephonne {
    private int valeur;
    private String type;
    private int cinPersonne;

    public Telephonne(int valeur, String type, int cinPersonne) {
        this.valeur = valeur;
        this.type = type;
        this.cinPersonne = cinPersonne;
    }

    public Telephonne(int valeur, int cinPersonne) {
        this.valeur = valeur;
        this.type = null;
        this.cinPersonne = cinPersonne;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCinPersonne() {
        return cinPersonne;
    }

    public void setCinPersonne(int cinPersonne) {
        this.cinPersonne = cinPersonne;
    }

}
