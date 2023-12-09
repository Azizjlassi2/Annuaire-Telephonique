package Persistance;

import java.util.List;

import Models.Telephonne;

public interface TelephonneDAO {
    public List<Telephonne> getAllTelephonne();

    public Telephonne getTelephonne(int valeur);

    public void updateTelephonne(Telephonne telephonne);

    public void deleteTelephonne(int valeur);

}
