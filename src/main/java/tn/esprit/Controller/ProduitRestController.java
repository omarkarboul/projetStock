package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Produit;
import tn.esprit.Service.ProduitService;

@RestController
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	ProduitService produitService;

	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		List<Produit> listProduits = produitService.retrieveAllProduits();
		return listProduits;
	}

	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	@PostMapping("/add-produit/{rayon-id}/{stock-id}")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p, @PathVariable("rayon-id") Long idRayon,
			@PathVariable("stock-id") Long idStock) {
		Produit produit = produitService.addProduit(p, idRayon, idStock);
		return produit;
	}

}
