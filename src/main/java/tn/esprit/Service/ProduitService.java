package tn.esprit.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Entity.Produit;

@Service
public interface ProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);

	void assignFournisseurToProduit(Long fournisseurId, Long produitId);
}
