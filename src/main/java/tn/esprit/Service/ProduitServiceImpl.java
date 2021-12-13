package tn.esprit.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.DetailProduit;
import tn.esprit.Entity.Produit;
import tn.esprit.Entity.Stock;
import tn.esprit.Repository.DetailProduitRepository;
import tn.esprit.Repository.FactureRepository;
import tn.esprit.Repository.FournisseurRepository;
import tn.esprit.Repository.ProduitRepository;
import tn.esprit.Repository.RayonRepository;
import tn.esprit.Repository.StockRepository;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	DetailProduitRepository detailProduitRepository;
	@Autowired
	FactureRepository factureRepository;
	@Autowired
	RayonRepository rayonRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	DetailProduitServiceImpl detailProduitServiceImpl;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		return produits;
	}

	@Transactional
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		p.setRayon(rayonRepository.findById(idRayon).orElse(null));
		Stock s = stockRepository.findById(idStock).orElse(null);
		p.setStock(s);
		s.setQte(s.getQte() + 1);
		stockRepository.save(s);
		DetailProduit db = p.getDetailProduit();
		db.setProduit(p);
		detailProduitServiceImpl.addDetailProduit(db);
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		Produit produit = produitRepository.findById(id).orElse(null);
		return produit;
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit produit = produitRepository.findById(idProduit).orElse(null);
		produit.setStock(stockRepository.findById(idStock).orElse(null));
		produitRepository.save(produit);
	}

	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Produit produit = produitRepository.findById(produitId).orElse(null);
		produit.getFournisseurs().add(fournisseurRepository.findById(fournisseurId).orElse(null));
	}

}
