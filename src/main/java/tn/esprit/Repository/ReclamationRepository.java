package tn.esprit.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Client;
import tn.esprit.Entity.Facture;
import tn.esprit.Entity.Reclamation;
import tn.esprit.Entity.Stock;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation, Long> {
	@Query(value = "SELECT * FROM reclamation r WHERE r.id_fournisseur= :idFournisseur" , nativeQuery =
			true)
	List<Reclamation> getReclationByIdFournisseur(@Param("idFournisseur") Long idFournisseur);

}
