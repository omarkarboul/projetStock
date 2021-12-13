package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Long> {

	@Query("SELECT f FROM Facture f WHERE f.dateFacture BETWEEN '2021-01-01' AND '2021-12-31'  ")
	List<Facture> chiffreAffaire();

	@Query("SELECT f FROM Facture f WHERE f.client = :idclient ")
	List<Facture> getFactureByClient(@Param("idclient") Long idclient);
}
