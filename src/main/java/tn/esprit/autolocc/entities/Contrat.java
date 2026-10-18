package tn.esprit.autolocc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @Column(nullable = false)
    private LocalDate dateSignature;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;

    @Column(nullable = false)
    private boolean valide;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", unique = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Reservation reservation;

    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Paiement> paiements = new ArrayList<>();

    public void attachReservation(Reservation reservation) {
        if (this.reservation == reservation) {
            return;
        }
        Reservation previousReservation = this.reservation;
        this.reservation = reservation;
        if (previousReservation != null && previousReservation.getContrat() == this) {
            previousReservation.detachContrat();
        }
        if (reservation != null && reservation.getContrat() != this) {
            reservation.attachContrat(this);
        }
    }

    public void addPaiement(Paiement paiement) {
        if (paiement != null) {
            Contrat previousContrat = paiement.getContrat();
            if (previousContrat != null && previousContrat != this) {
                previousContrat.removePaiement(paiement);
            }
            if (!paiements.contains(paiement)) {
                paiements.add(paiement);
            }
            paiement.setContrat(this);
        }
    }

    public void removePaiement(Paiement paiement) {
        if (paiements.remove(paiement) && paiement.getContrat() == this) {
            paiement.setContrat(null);
        }
    }
}