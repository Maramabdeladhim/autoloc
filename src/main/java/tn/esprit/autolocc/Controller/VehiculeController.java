package tn.esprit.autolocc.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocc.Services.IVehiculeService;
import tn.esprit.autolocc.entities.Vehicule;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    public VehiculeController(IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @PostMapping
    public Vehicule ajouter(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @GetMapping
    public List<Vehicule> afficher() {
        return vehiculeService.consulterVehicules();
    }

    @GetMapping("/{id}")
    public Vehicule rechercher(@PathVariable Long id) {
        return vehiculeService.consulterVehiculeById(id);
    }

    @PutMapping
    public Vehicule modifier(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        vehiculeService.supprimerVehiculeById(id);
    }
}
