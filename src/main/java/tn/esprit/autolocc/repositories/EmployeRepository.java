package tn.esprit.autolocc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocc.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
