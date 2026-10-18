package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Vehicule;

import java.util.List;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule vehicule);

    Vehicule modifierVehicule(Vehicule vehicule);

    List<Vehicule> consulterVehicules();

    Vehicule consulterVehiculeById(Long idVehicule);

    void supprimerVehiculeById(Long idVehicule);
}
