package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Fournisseur;
@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {

}
