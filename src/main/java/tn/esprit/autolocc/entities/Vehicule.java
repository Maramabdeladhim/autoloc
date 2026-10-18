package tn.esprit.autolocc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.autolocc.entities.enums.StatutVehicule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehicule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;

    @Column(nullable = false, length = 50)
    private String marque;

    @Column(nullable = false, length = 50)
    private String modele;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private tn.esprit.autolocc.entities.enums.CategorieVehicule categorie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Agence agence;

    @OneToMany(mappedBy = "vehicule")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Maintenance> maintenances = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "idVehicule"),
            inverseJoinColumns = @JoinColumn(name = "idEquipement")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Equipement> equipements = new HashSet<>();

    @OneToMany(mappedBy = "vehicule")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Reservation> reservations = new ArrayList<>();

    public void addMaintenance(Maintenance maintenance) {
        if (maintenance != null) {
            Vehicule previousVehicule = maintenance.getVehicule();
            if (previousVehicule != null && previousVehicule != this) {
                previousVehicule.removeMaintenance(maintenance);
            }
            if (!maintenances.contains(maintenance)) {
                maintenances.add(maintenance);
            }
            maintenance.setVehicule(this);
        }
    }

    public void removeMaintenance(Maintenance maintenance) {
        if (maintenances.remove(maintenance) && maintenance.getVehicule() == this) {
            maintenance.setVehicule(null);
        }
    }

    public void addEquipement(Equipement equipement) {
        if (equipement != null && equipements.add(equipement)) {
            equipement.getVehicules().add(this);
        }
    }

    public void removeEquipement(Equipement equipement) {
        if (equipements.remove(equipement)) {
            equipement.getVehicules().remove(this);
        }
    }

    public void addReservation(Reservation reservation) {
        if (reservation != null) {
            Vehicule previousVehicule = reservation.getVehicule();
            if (previousVehicule != null && previousVehicule != this) {
                previousVehicule.removeReservation(reservation);
            }
            if (!reservations.contains(reservation)) {
                reservations.add(reservation);
            }
            reservation.setVehicule(this);
        }
    }

    public void removeReservation(Reservation reservation) {
        if (reservations.remove(reservation) && reservation.getVehicule() == this) {
            reservation.setVehicule(null);
        }
    }
    public void removeReservations(Reservation reservation) {
        if (reservations.remove(reservation) && reservation.getVehicule() == this) {
            reservation.setVehicule(null);
        }
    }
}
