package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Fournisseur;
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{
	
}
