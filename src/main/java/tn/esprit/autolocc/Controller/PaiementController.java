package tn.esprit.autolocc.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocc.Services.IPaiementService;
import tn.esprit.autolocc.entities.Paiement;

import java.util.List;

@RestController
@RequestMapping("/paiements")
public class PaiementController {
    private final IPaiementService paiementService;

    public PaiementController(IPaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping
    public Paiement ajouter(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @GetMapping
    public List<Paiement> afficher() {
        return paiementService.consulterPaiements();
    }

    @GetMapping("/{id}")
    public Paiement rechercher(@PathVariable Long id) {
        return paiementService.consulterPaiementById(id);
    }

    @PutMapping
    public Paiement modifier(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        paiementService.supprimerPaiementById(id);
    }
}
