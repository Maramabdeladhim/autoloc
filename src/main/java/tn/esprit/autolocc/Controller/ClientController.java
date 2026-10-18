package tn.esprit.autolocc.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocc.Services.IClientService;
import tn.esprit.autolocc.entities.Client;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client ajouter(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @GetMapping
    public List<Client> afficher() {
        return clientService.consulterClients();
    }

    @GetMapping("/{id}")
    public Client rechercher(@PathVariable Long id) {
        return clientService.consulterClientById(id);
    }

    @PutMapping
    public Client modifier(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        clientService.supprimerClientById(id);
    }
}
