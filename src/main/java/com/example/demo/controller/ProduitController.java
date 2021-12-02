package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Produit;
import com.example.demo.service.IproduitService;
import com.example.demo.service.date12;

@Controller
@RequestMapping("/produit")
@CrossOrigin
public class ProduitController {

	@Autowired
	IproduitService produitservice;

	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		List<Produit> listProduits = produitservice.retrieveAllProduits();
		return listProduits;
	}

	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveProdduit(@PathVariable("produit-id") Long ProduitId) {
		return produitservice.retrieveProduit(ProduitId);
	}

	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-produit/{rayon-id}/{stock-id}")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p, @PathVariable("rayon-id") Long rayonId,
			@PathVariable("stock-id") Long StockId) {
		Produit produit = produitservice.addProduit(p, StockId, rayonId);
		return produit;
	}

	@PostMapping("/assignprodtostock/{produit-id}/{stock-id}")
	public void assignprodtostock(@PathVariable("produit-id") Long prodId, @PathVariable("stock-id") Long stockId) {
		produitservice.assignProduitToStock(prodId, stockId);

	}

	@PostMapping("/assignprodtofourn/{fourn-id}/{produit-id}")
	public void assignfourtoproduit(@PathVariable("fourn-id") Long fourId, @PathVariable("produit-id") Long prodId) {
		produitservice.assignFournisseurToProduit(fourId, prodId);

	}

	@GetMapping("/RevenuParProduit/{idproduit}")
	@ResponseBody
	public float RevenuParProduit(@RequestBody date12 date, @PathVariable("idproduit") Long idproduit) {
		return produitservice.getRevenuBrutProduit(idproduit, date.getDate1(), date.getDate2());
	}
}
