package tn.esprit.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

	@Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN :d1 AND :d2  ")
	List<Client> findBetweenDateNaissance(@Param("d1") Date d1, @Param("d2") Date d2);

}
