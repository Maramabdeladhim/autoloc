package tn.esprit.autolocc.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocc.Services.IReservationService;
import tn.esprit.autolocc.entities.Reservation;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Reservation ajouter(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @GetMapping
    public List<Reservation> afficher() {
        return reservationService.consulterReservations();
    }

    @GetMapping("/{id}")
    public Reservation rechercher(@PathVariable Long id) {
        return reservationService.consulterReservationById(id);
    }

    @PutMapping
    public Reservation modifier(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable Long id) {
        reservationService.supprimerReservationById(id);
    }
}
