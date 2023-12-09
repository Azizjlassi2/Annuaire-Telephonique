package Services;

import java.util.ArrayList;

import Models.Personne;
import Models.Telephonne;
import Persistance.TelephonneDAO;

public class TelephoneService {
    private TelephonneDAO telephoneDAO;

    public TelephoneService(TelephonneDAO telephoneDAO) {
        this.telephoneDAO = telephoneDAO;
    }

    public void ajouterTelephone(Personne personne, Telephonne telephone) {
        telephoneDAO.ajouterTelephone(personne, telephone);
    }

    public void listerTelephones(Personne personne) {
        telephoneDAO.listerTelephones(personne);
    }

    public void supprimerTelephone(Personne personne, Telephonne telephone) {
        telephoneDAO.supprimerTelephone(personne, telephone);
    }
}
