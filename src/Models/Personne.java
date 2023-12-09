package Models;

import java.util.ArrayList;

public class Personne {

    private int cin;
    private String nom;
    private String prenom;
    private String civilite;

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    private ArrayList<Telephonne> listTet;

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ArrayList<Telephonne> getListTet() {
        return listTet;
    }

    public void setListTet(ArrayList<Telephonne> listTet) {
        this.listTet = listTet;
    }

    public Personne(int cin, String nom, String prenom, String civilite) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
    }
}