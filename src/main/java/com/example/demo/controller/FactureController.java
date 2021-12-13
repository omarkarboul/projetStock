package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Facture;
import com.example.demo.service.iFactureService;

@Controller
@RequestMapping("/facture")
public class FactureController {

	@Autowired
	iFactureService factureService;

	@GetMapping("/retrieve-all-factures")
	@ResponseBody
	public List<Facture> getFactures() {
		List<Facture> factures = factureService.retrieveAllFactures();
		return factures;
	}

	@PostMapping("/add-factures/{clientid}")
	@ResponseBody
	public Facture addFacture(@RequestBody Facture f, @PathVariable("clientid") Long clientID) {
		return factureService.addFacture(f, clientID);

	}

	@GetMapping("/retrieve-facture/{factureId}")
	@ResponseBody
	public Facture retrieveFacture(@PathVariable("factureId") Long factureId) {
		return factureService.retrieveFacture(factureId);
	}

	@DeleteMapping("/remove-facture/{factureId}")
	@ResponseBody
	public void cancelFacture(@PathVariable("factureId") Long factureId) {
		factureService.cancelFacture(factureId);
	}

	@GetMapping("/get-facturebyclient/{clientId}")
	@ResponseBody
	public List<Facture> getFactureByClient(@PathVariable("clientId") Long clientId) {
		List<Facture> factures = factureService.getFactureByClient(clientId);
		return factures;
	}


}
