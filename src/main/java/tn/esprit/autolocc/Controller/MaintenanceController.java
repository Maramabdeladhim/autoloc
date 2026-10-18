package tn.esprit.autolocc.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocc.Services.IMaintenanceService;
import tn.esprit.autolocc.entities.Maintenance;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    public MaintenanceController(IMaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping
    public Maintenance ajouter(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @GetMapping
    public List<Maintenance> afficher() {
        return maintenanceService.consulterMaintenances();
    }

    @GetMapping("/{id}")
    public Maintenance rechercher(@PathVariable Long id) {
        return maintenanceService.consulterMaintenanceById(id);
    }

    @PutMapping
    public Maintenance modifier(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        maintenanceService.supprimerMaintenanceById(id);
    }
}
