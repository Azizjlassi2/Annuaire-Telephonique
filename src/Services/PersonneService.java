package Services;

import java.util.ArrayList;
import java.util.List;

import Persistance.PersonneDAO;

import Models.Personne;

public class PersonneService {
    private PersonneDAO personneDAO;

    public PersonneService(PersonneDAO personneDAO) {
        this.personneDAO = personneDAO;
    }

    public void ajouterPersonne(Personne personne) {
        personneDAO.ajouterPersonne(personne);
    }

    public void modifierPersonne(Personne personne) {
        personneDAO.modifierPersonne(personne);
    }

    public void supprimerPersonne(Personne personne) {
        personneDAO.supprimerPersonne(personne);
    }

    public List<Personne> listerPersonnes() {
        return personneDAO.listerPersonnes();
    }

}
