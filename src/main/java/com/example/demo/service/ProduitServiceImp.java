package com.example.demo.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CategorieProduit;
import com.example.demo.entities.Fournisseur;
import com.example.demo.entities.Produit;
import com.example.demo.entities.Rayon;
import com.example.demo.entities.Stock;
import com.example.demo.entities.detailFacture;
import com.example.demo.entities.detailProduit;
import com.example.demo.repository.DetailFactureRepository;
import com.example.demo.repository.DetailProduitRepository;
import com.example.demo.repository.FournisseurRepository;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.RayonRepository;
import com.example.demo.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitServiceImp implements IproduitService {
	
	@Autowired
	ProduitRepository produitrepos;
	
	@Autowired
	FournisseurRepository fournisseurrepos;
	
	@Autowired
	DetailProduitRepository detproduitrepos ;
	
	@Autowired
	RayonRepository rayonrepos;
	
	@Autowired
	StockRepository stockrepos;

	@Autowired
	DetailFactureRepository detfactrepos ;
	
	@Override
	public List<Produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		return produitrepos.findAll();
	}

	@Override
	@Transactional
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		
		Rayon r = rayonrepos.findById(idRayon).get();
		Stock s = stockrepos.findById(idStock).get();
		p.setRayon(r);
		p.setStock(s);
		detailProduit dp = new detailProduit();
		Date now = new Date();
		dp.setDateCreation(now);
		dp.setDateDerniereModification(now);
		dp.setProduit(p);
		p.setDetailproduit(dp);
		detproduitrepos.save(dp);
		
		return produitrepos.save(p);
	}
	
	@Transactional
	public Produit addProduit2(Produit p, Long idRayon, Long idStock, CategorieProduit cat) {
		Rayon r = rayonrepos.findById(idRayon).get();
		Stock s = stockrepos.findById(idStock).get();
		p.setRayon(r);
		p.setStock(s);
		detailProduit dp = new detailProduit();
		Date now = new Date();
		dp.setDateCreation(now);
		dp.setDateDerniereModification(now);
		dp.setCategorieProduit(cat);
		dp.setProduit(p);
		p.setDetailproduit(dp);
		detproduitrepos.save(dp);
		
		return produitrepos.save(p);
	}
	
	@Transactional
	public Produit updateProduit(Produit p, Long idRayon, Long idStock) {
		
		Rayon r = rayonrepos.findById(idRayon).get();
		Stock s = stockrepos.findById(idStock).get();
		p.setRayon(r);
		p.setStock(s);
		
		
		return produitrepos.save(p);
	}
		
	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		return produitrepos.getById(id);
	}

	@Transactional
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p = produitrepos.getById(idProduit);
		p.setStock(stockrepos.getById(idStock));
		produitrepos.save(p);
		log.info("assigned stock with id :"+idStock+"to product :"+idProduit);
		
		
	}

	@Transactional
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Produit p = produitrepos.getById(produitId);
		Fournisseur f = fournisseurrepos.getById(fournisseurId);
		if(p.getFournisseurs() == null) {
			List<Fournisseur> fns = new ArrayList<>();
			fns.add(f);
			p.setFournisseurs(fns);
		}else {
			p.getFournisseurs().add(f);
		}
		
		produitrepos.save(p);
		log.info("assigned provider with id :"+fournisseurId+"to product :"+produitId);
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		List <detailFacture> ls = detfactrepos.detfactbyprodanddate(idProduit, startDate, endDate);
		float x = 0 ;
		for(detailFacture df : ls) {
			x+=(df.getPrixTotal()*df.getPourcentageRemise());
		}
		return x;
	}

	@Override
	public List<Produit> getProductsByCategory(CategorieProduit cat) {
		// TODO Auto-generated method stub
		return produitrepos.getProductsByCategory(cat);
	}



	@Override
	public void deleteProduit(Long id) {
		produitrepos.delete(produitrepos.getById(id));
		
	}

	@Override
	public Produit updateProd(Produit p) {
		// TODO Auto-generated method stub
		return produitrepos.save(p);
	}

	

}
