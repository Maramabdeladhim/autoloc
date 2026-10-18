package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Equipement;

import java.util.List;

public interface IEquipementService {
    Equipement ajouterEquipement(Equipement equipement);

    Equipement modifierEquipement(Equipement equipement);

    List<Equipement> consulterEquipements();

    Equipement consulterEquipementById(Long idEquipement);

    void supprimerEquipementById(Long idEquipement);
}
