package tn.esprit.autolocc.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocc.Services.IAgenceService;
import tn.esprit.autolocc.entities.Agence;

import java.util.List;

@RestController
@RequestMapping("/agences")
public class AgenceController {
    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @PostMapping
    public Agence ajouter(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @GetMapping
    public List<Agence> afficher() {
        return agenceService.consulterAgences();
    }

    @GetMapping("/{id}")
    public Agence rechercher(@PathVariable Long id) {
        return agenceService.consulterAgenceById(id);
    }

    @PutMapping
    public Agence modifier(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        agenceService.supprimerAgenceById(id);
    }
}
