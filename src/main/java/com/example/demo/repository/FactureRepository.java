package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

	@Query("SELECT f FROM Facture f WHERE f.dateFacture BETWEEN '2021-01-01' AND '2021-12-31'  ")
	List<Facture> chiffreAffaire();

	@Query("select f from Facture f where f.client.idClient =:clientid")
	List<Facture> getFacturesByClient(@Param("clientid") Long clientid);

}
