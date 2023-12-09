package Persistance;

import java.util.List;

import Models.Personne;

public interface PersonneDAO {
    public List<Personne> getAllPersonne();

    public Personne getPersonne(int cin);

    public void ajouterPersonne(Personne personne);

    public void updatePersonne(Personne personne);

    public void deletePersonne(int cin);

}
