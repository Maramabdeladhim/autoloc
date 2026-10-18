package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocc.entities.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
