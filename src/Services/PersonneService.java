package Services;

import java.util.List;

import Persistance.PersonneDAO;

import Models.Personne;

public class PersonneService {
    private PersonneDAO personneDAO;

    public PersonneService() {
    }

    public void ajouterPersonne(Personne personne) {
        personneDAO.ajouterPersonne(personne);
    }

    public Personne selectionnerPersonne(int cin) {
        return personneDAO.getPersonne(cin);
    }

    public void modifierPersonne(Personne personne) {
        personneDAO.updatePersonne(personne);
    }

    public void supprimerPersonne(Personne personne) {
        personneDAO.deletePersonne(personne.getCin());
    }

    public List<Personne> listerPersonnes() {
        return personneDAO.getAllPersonne();

    }
}
