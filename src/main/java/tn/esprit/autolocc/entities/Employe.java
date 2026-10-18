package tn.esprit.autolocc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.autolocc.entities.enums.Role;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Employe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long idEmploye;
    String nomEmploye;
    String prenomEmploye;

    @Enumerated(EnumType.STRING)
    Role Role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Agence agence;
}
