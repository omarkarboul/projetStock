package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Facture;
import tn.esprit.Service.FactureService;

@RestController
@RequestMapping("/facture")
public class FactureRestController {

	@Autowired
	FactureService factureService;

	@GetMapping("/retrieve-all-factures")
	@ResponseBody
	public List<Facture> getFactures() {
		List<Facture> factures = factureService.retrieveAllFactures();
		return factures;
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
