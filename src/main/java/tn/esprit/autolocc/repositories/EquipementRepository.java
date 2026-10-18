package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocc.entities.Equipement;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}
