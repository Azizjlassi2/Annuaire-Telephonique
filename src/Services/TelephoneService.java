package Services;

import Models.Personne;
import Models.Telephonne;
import Persistance.TelephonneDAO;

public class TelephoneService {
    private TelephonneDAO telephoneDAO;

    public TelephoneService() {
    }

    public void ajouterTelephone(Personne personne, Telephonne telephone) {
        telephoneDAO.ajouterTelephonne(personne, telephone);
    }

    public void listerTelephones() {
        telephoneDAO.getAllTelephonne();
    }

    public void supprimerTelephone(int personneID) {
        telephoneDAO.deleteTelephonne(personneID);
    }

    public void modifierTelephone(Telephonne telephone) {
        telephoneDAO.updateTelephonne(telephone);
    }
}
