package com.example.demo.controller;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.CategorieProduit;
import com.example.demo.entities.Produit;
import com.example.demo.entities.Stock;
import com.example.demo.service.CloudinaryService;
import com.example.demo.service.IproduitService;
import com.example.demo.service.Message;
import com.example.demo.service.date12;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/produit")
@CrossOrigin
public class ProduitController {

	@Autowired
	IproduitService produitservice ;
	
	@Autowired
	CloudinaryService cloudinaryservice ;
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
		public Produit addProduit(@RequestBody Produit p , @PathVariable("rayon-id") Long rayonId , @PathVariable("stock-id") Long StockId)
		{
		Produit produit = produitservice.addProduit(p, rayonId, StockId);
		return produit;
		}
		
		@PostMapping("/assignprodtostock/{produit-id}/{stock-id}")
		public void assignprodtostock(@PathVariable("produit-id") Long prodId , @PathVariable("stock-id") Long stockId)
		{
		produitservice.assignProduitToStock(prodId, stockId);

		}
		
		@PostMapping("/assignprodtofourn/{fourn-id}/{produit-id}")
		public void assignfourtoproduit(@PathVariable("fourn-id") Long fourId , @PathVariable("produit-id") Long prodId)
		{
		produitservice.assignFournisseurToProduit(fourId, prodId);

		}
		
		@GetMapping("/RevenuParProduit/{idproduit}")
		@ResponseBody
		public float RevenuParProduit(@RequestBody date12 date, @PathVariable("idproduit") Long idproduit) {
		return produitservice.getRevenuBrutProduit(idproduit,date.getDate1(), date.getDate2());
		}
		
		
		@GetMapping("/getproductsbtcat/{cat}")
		@ResponseBody
		public List<Produit> getProduitsBycats(@PathVariable("cat") CategorieProduit cat) {
		List<Produit> listProduits = produitservice.getProductsByCategory(cat);
		return listProduits;
		}
		
		@PutMapping("/update-produit/{rayon-id}/{stock-id}/{cat}")
		@ResponseBody
		public Produit updateProd(@RequestBody Produit p,@PathVariable("rayon-id") Long rayonId , @PathVariable("stock-id") Long StockId , @PathVariable("cat") CategorieProduit cat) {
			//p.setRayon(rayon)
			return produitservice.updateProd(p);
		}
		
		@DeleteMapping("/remove-produit/{produit-id}")
		@ResponseBody
		public void deleteStock(@PathVariable("produit-id") Long produitID) {
			produitservice.deleteProduit(produitID);
		}
		
		
		@PostMapping("/testcloud")
		public ResponseEntity<Map> upload(@RequestParam MultipartFile multipartfile) throws IOException{
			
			BufferedImage bi = ImageIO.read(multipartfile.getInputStream());
			if(bi == null) {
				return new ResponseEntity(new Message("image non valide"), HttpStatus.BAD_REQUEST);
			}
			Map result = cloudinaryservice.upload(multipartfile);
			return new ResponseEntity(result, HttpStatus.OK);
		}
		
		
		@PostMapping("/add-produit2/{rayon-id}/{stock-id}/{cat}")
		public ResponseEntity<?> addProduit2(@ModelAttribute Produit p ,@RequestParam MultipartFile multipartfile, @PathVariable("rayon-id") Long rayonId , @PathVariable("stock-id") Long StockId , @PathVariable("cat") CategorieProduit cat) throws IOException
		{
		
		BufferedImage bi = ImageIO.read(multipartfile.getInputStream());
		if(bi == null) {
			return new ResponseEntity(new Message("image non valide"), HttpStatus.BAD_REQUEST);
		}
		Map result = cloudinaryservice.upload(multipartfile);
		p.setImage((String) result.get("url"));
		produitservice.addProduit2(p, rayonId, StockId,cat);
		return new ResponseEntity(result, HttpStatus.OK);
	
		}
		
		@PutMapping("/update-produit2/{rayon-id}/{stock-id}/")
		public ResponseEntity<?> updateproduit(@ModelAttribute Produit p ,@RequestParam MultipartFile multipartfile, @PathVariable("rayon-id") Long rayonId , @PathVariable("stock-id") Long StockId) throws IOException
		{
		
		BufferedImage bi = ImageIO.read(multipartfile.getInputStream());
		if(bi == null) {
			return new ResponseEntity(new Message("image non valide"), HttpStatus.BAD_REQUEST);
		}
		Map result = cloudinaryservice.upload(multipartfile);
		p.setImage((String) result.get("url"));
		produitservice.updateProduit(p, rayonId, StockId);
		return new ResponseEntity(result, HttpStatus.OK);
	
		}
		
		@PostMapping("/add-produit3/{rayon-id}/{stock-id}")
		public ResponseEntity<?> addProduit3(@RequestParam String Pstring ,@RequestParam MultipartFile multipartfile, @PathVariable("rayon-id") Long rayonId , @PathVariable("stock-id") Long StockId) throws IOException
		{
			ObjectMapper objectMapper = new ObjectMapper();
			Produit p = objectMapper.readValue(Pstring, Produit.class);
			
		BufferedImage bi = ImageIO.read(multipartfile.getInputStream());
		if(bi == null) {
			return new ResponseEntity(new Message("image non valide"), HttpStatus.BAD_REQUEST);
		}
		Map result = cloudinaryservice.upload(multipartfile);
		p.setImage((String) result.get("url"));
		produitservice.addProduit(p, rayonId, StockId);
		return new ResponseEntity(result, HttpStatus.OK);
	
		}
		
		
}
