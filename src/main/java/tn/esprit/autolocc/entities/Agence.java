package tn.esprit.autolocc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 50)
    private String ville;

    @Column(nullable = false, length = 150)
    private String adresse;

    @Column(nullable = false, length = 20)
    private String telephone;

    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Employe> employes = new ArrayList<>();

    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vehicule> vehicules = new ArrayList<>();

    public void addEmploye(Employe employe) {
        if (employe != null) {
            Agence previousAgence = employe.getAgence();
            if (previousAgence != null && previousAgence != this) {
                previousAgence.removeEmploye(employe);
            }
            if (!employes.contains(employe)) {
                employes.add(employe);
            }
            employe.setAgence(this);
        }
    }

    public void removeEmploye(Employe employe) {
        if (employes.remove(employe) && employe.getAgence() == this) {
            employe.setAgence(null);
        }
    }

    public void addVehicule(Vehicule vehicule) {
        if (vehicule != null) {
            Agence previousAgence = vehicule.getAgence();
            if (previousAgence != null && previousAgence != this) {
                previousAgence.removeVehicule(vehicule);
            }
            if (!vehicules.contains(vehicule)) {
                vehicules.add(vehicule);
            }
            vehicule.setAgence(this);
        }
    }

    public void removeVehicule(Vehicule vehicule) {
        if (vehicules.remove(vehicule) && vehicule.getAgence() == this) {
            vehicule.setAgence(null);
        }
    }
}