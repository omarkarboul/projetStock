package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

//		@Query(value = "update facture set active = false where id_facture=:id ")
//	    void CancelFacture cancelfacture(@Param("id") Long id);

	@Query("select f from Facture f where f.client.idClient =:clientid")
	List<Facture> getFacturesByClient(@Param("clientid") Long clientid);

}
