package com.example.demo.controller;

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

import com.example.demo.entities.detailProduit;
import com.example.demo.service.DetailProduitService;

@RestController
@RequestMapping("/detailproduit")

public class DetailFactureController {

	@Autowired
	DetailProduitService detailProduitService;

	@GetMapping("/retrieve-all-detailproduits")
	@ResponseBody
	public List<detailProduit> getDetailProduits() {
		List<detailProduit> detailProduits = detailProduitService.retrieveAllDetailProduit();
		return detailProduits;
	}

	@GetMapping("/retrieve-detailproduit/{detailProduitId}")
	@ResponseBody
	public detailProduit retrieveDetailProduit(@PathVariable("detailProduitId") Long detailProduitId) {
		return detailProduitService.retrieveDetailProduit(detailProduitId);
	}

	@PostMapping("/add-detailproduit")
	@ResponseBody
	public detailProduit addDetailProduit(@RequestBody detailProduit c) {
		detailProduit detailProduit = detailProduitService.addDetailProduit(c);
		return detailProduit;
	}

	@DeleteMapping("/remove-detailproduit/{detailProduitId}")
	@ResponseBody
	public void removeDetailProduit(@PathVariable("detailProduitId") Long detailProduitId) {
		detailProduitService.deleteDetailProduit(detailProduitId);
	}

	@PutMapping("/modify-detailproduit")
	@ResponseBody
	public detailProduit modifyDetailProduit(@RequestBody detailProduit detailProduit) {
		return detailProduitService.updateDetailProduit(detailProduit);
	}

}
