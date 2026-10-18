// Reservation.java
package tn.esprit.autolocc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.autolocc.entities.enums.StatutReservation;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(nullable = false)
    private LocalDate dateDebut;

    @Column(nullable = false)
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutReservation statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Vehicule vehicule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Client client;

    @OneToOne(mappedBy = "reservation", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Contrat contrat;

    public void attachContrat(Contrat contrat) {
        if (contrat == null) {
            detachContrat();
            return;
        }
        if (this.contrat != contrat) {
            detachContrat();
            this.contrat = contrat;
            contrat.attachReservation(this);
        }
    }

    public void detachContrat() {
        Contrat previousContrat = this.contrat;
        this.contrat = null;
        if (previousContrat != null && previousContrat.getReservation() == this) {
            previousContrat.attachReservation(null);
        }
    }
}