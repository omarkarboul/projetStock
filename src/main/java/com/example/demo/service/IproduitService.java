package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Produit;

public interface IproduitService {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);
	
	void assignProduitToStock(Long idProduit, Long idStock);
	
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId);

	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}