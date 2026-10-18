package tn.esprit.autolocc.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocc.Services.IEmployeService;
import tn.esprit.autolocc.entities.Employe;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeController {
    private final IEmployeService employeService;

    public EmployeController(IEmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping
    public Employe ajouter(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @GetMapping
    public List<Employe> afficher() {
        return employeService.consulterEmployes();
    }

    @GetMapping("/{id}")
    public Employe rechercher(@PathVariable Long id) {
        return employeService.consulterEmployeById(id);
    }

    @PutMapping
    public Employe modifier(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        employeService.supprimerEmployeById(id);
    }
}
