package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Paiement;

import java.util.List;

public interface IPaiementService {
    Paiement ajouterPaiement(Paiement paiement);

    Paiement modifierPaiement(Paiement paiement);

    List<Paiement> consulterPaiements();

    Paiement consulterPaiementById(Long idPaiement);

    void supprimerPaiementById(Long idPaiement);
}
