package tn.esprit.autolocc.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocc.Services.IEquipementService;
import tn.esprit.autolocc.entities.Equipement;

import java.util.List;

@RestController
@RequestMapping("/equipements")
public class EquipementController {
    private final IEquipementService equipementService;

    public EquipementController(IEquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @PostMapping
    public Equipement ajouter(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @GetMapping
    public List<Equipement> afficher() {
        return equipementService.consulterEquipements();
    }

    @GetMapping("/{id}")
    public Equipement rechercher(@PathVariable Long id) {
        return equipementService.consulterEquipementById(id);
    }

    @PutMapping
    public Equipement modifier(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        equipementService.supprimerEquipementById(id);
    }
}
