package Persistance;

import java.util.List;

import Models.Personne;
import Models.Telephonne;

public interface TelephonneDAO {
    public List<Telephonne> getAllTelephonne();

    public Telephonne getTelephonne(int valeur);

    public void ajouterTelephonne(Personne personne, Telephonne telephone);

    public void updateTelephonne(Telephonne telephonne);

    public void deleteTelephonne(int personne_id);

}
