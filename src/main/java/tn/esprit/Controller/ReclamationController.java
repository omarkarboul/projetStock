package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entity.Reclamation;
import tn.esprit.Service.ReclamationService;

@RestController
@Slf4j
@RequestMapping("/reclamation")
public class ReclamationController {
	@Autowired
	ReclamationService reclamationService;

	@GetMapping("/retrieve-all-Reclamations")
	@ResponseBody
	public List<Reclamation> getReclamations() {
		List<Reclamation> Reclamations = reclamationService.retrieveAllReclamations();
		return Reclamations;
	}

	@GetMapping("/retrieve-Reclamation/{ReclamationId}")
	@ResponseBody
	public Reclamation retrieveReclamation(@PathVariable("ReclamationId") Long ReclamationId) {
		return reclamationService.retrieveReclamation(ReclamationId);
	}

	@PostMapping("/add-reclamation")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation c) {
		log.info(""+c);
		Reclamation reclamation = reclamationService.addReclamation(c);
		return reclamation;
	}

	@DeleteMapping("/remove-Reclamation/{ReclamationId}")
	@ResponseBody
	public void removeReclamation(@PathVariable("ReclamationId") Long ReclamationId) {
		reclamationService.deleteReclamation(ReclamationId);
	}

	@PutMapping("/modify-Reclamation")
	@ResponseBody
	public Reclamation modifyReclamation(@RequestBody Reclamation Reclamation) {
		return reclamationService.updateReclamation(Reclamation);
	}
	
	@GetMapping("/retrieve-ReclamationByIdFournisseur/{FournisseurId}")
	@ResponseBody
	public List<Reclamation> ReclamationByIdFournisseur(@PathVariable("FournisseurId") Long FournisseurId) {
		return reclamationService.getReclamationsByIdFournisseur(FournisseurId);
		
	}


}
