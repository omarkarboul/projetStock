package com.example.demo.repository;

import java.util.Date; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;
import com.example.demo.entities.Facture;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select f from Facture f where f.client.categorieClient= ?1 and f.dateFacture BETWEEN ?2 AND ?3")
    List<Facture> CAbyCategorieCategorieClient (CategorieClient cat ,Date d1 , Date d2);

	@Query("select c from Client c where c.dateNaissance BETWEEN ?1 AND ?2")
	List<Client> ClientsWithDateBirth(Date d1 , Date d2);
	
}
