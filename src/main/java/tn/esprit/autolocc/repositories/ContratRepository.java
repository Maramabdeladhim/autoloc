package tn.esprit.autolocc.repositories;


import tn.esprit.autolocc.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {

}