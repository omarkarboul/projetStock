package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.CategorieProduit;
import com.example.demo.entities.Produit;

public interface IproduitService {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);
	
	Produit addProduit2(Produit p, Long idRayon, Long idStock, CategorieProduit cat);
	
	Produit updateProduit(Produit p, Long idRayon, Long idStock);
	
	Produit updateProd(Produit p);
	
	void deleteProduit(Long id);

	Produit retrieveProduit(Long id);
	
	void assignProduitToStock(Long idProduit, Long idStock);
	
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId);

	float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
	
	List<Produit> getProductsByCategory(CategorieProduit cat);
}
