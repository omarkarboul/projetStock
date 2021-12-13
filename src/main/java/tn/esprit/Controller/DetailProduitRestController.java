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

import tn.esprit.Entity.DetailProduit;
import tn.esprit.Service.DetailProduitService;

@RestController
@RequestMapping("/detailproduit")
public class DetailProduitRestController {

	@Autowired
	DetailProduitService detailProduitService;

	@GetMapping("/retrieve-all-detailproduits")
	@ResponseBody
	public List<DetailProduit> getDetailProduits() {
		List<DetailProduit> detailProduits = detailProduitService.retrieveAllDetailProduit();
		return detailProduits;
	}

	@GetMapping("/retrieve-detailproduit/{detailProduitId}")
	@ResponseBody
	public DetailProduit retrieveDetailProduit(@PathVariable("detailProduitId") Long detailProduitId) {
		return detailProduitService.retrieveDetailProduit(detailProduitId);
	}

	@PostMapping("/add-detailproduit")
	@ResponseBody
	public DetailProduit addDetailProduit(@RequestBody DetailProduit c) {
		DetailProduit detailProduit = detailProduitService.addDetailProduit(c);
		return detailProduit;
	}

	@DeleteMapping("/remove-detailproduit/{detailProduitId}")
	@ResponseBody
	public void removeDetailProduit(@PathVariable("detailProduitId") Long detailProduitId) {
		detailProduitService.deleteDetailProduit(detailProduitId);
	}

	@PutMapping("/modify-detailproduit")
	@ResponseBody
	public DetailProduit modifyDetailProduit(@RequestBody DetailProduit detailProduit) {
		return detailProduitService.updateDetailProduit(detailProduit);
	}

}
