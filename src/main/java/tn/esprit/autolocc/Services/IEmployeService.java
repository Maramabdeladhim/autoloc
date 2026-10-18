package tn.esprit.autolocc.Services;

import tn.esprit.autolocc.entities.Employe;

import java.util.List;

public interface IEmployeService {
    Employe ajouterEmploye(Employe employe);

    Employe modifierEmploye(Employe employe);

    List<Employe> consulterEmployes();

    Employe consulterEmployeById(Long idEmploye);

    void supprimerEmployeById(Long idEmploye);
}
