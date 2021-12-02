package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.detailFacture;

@Repository
public interface DetailFactureRepository extends JpaRepository<detailFacture, Long> {

	@Query("select sum(prixTotal-montantremise) from detailFacture  ")
	float CAmagazin();

	@Query("select d from detailFacture d where d.produit.idProduit= ?1 AND d.facture.dateFacture BETWEEN ?2 AND ?3")
	List<detailFacture> detfactbyprodanddate(Long idproduit, Date d1, Date d2);
}
