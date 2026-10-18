package tn.esprit.autolocc.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocc.Services.IContratService;
import tn.esprit.autolocc.entities.Contrat;

import java.util.List;

@RestController
@RequestMapping("/contrats")
public class ContratController {
    private final IContratService contratService;

    public ContratController(IContratService contratService) {
        this.contratService = contratService;
    }

    @PostMapping
    public Contrat ajouter(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @GetMapping
    public List<Contrat> afficher() {
        return contratService.consulterContrats();
    }

    @GetMapping("/{id}")
    public Contrat rechercher(@PathVariable Long id) {
        return contratService.consulterContratById(id);
    }

    @PutMapping
    public Contrat modifier(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        contratService.supprimerContratById(id);
    }
}
