package tn.esprit.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.DetailProduit;
import tn.esprit.Repository.DetailProduitRepository;

@Service
public class DetailProduitServiceImpl implements DetailProduitService {

	@Autowired
	DetailProduitRepository detailProduitRepository;

	@Override
	public List<DetailProduit> retrieveAllDetailProduit() {
		List<DetailProduit> detailProduits = (List<DetailProduit>) detailProduitRepository.findAll();
		return detailProduits;
	}

	@Override
	public DetailProduit addDetailProduit(DetailProduit c) {
		Date date = new Date(System.currentTimeMillis());
		c.setDateCreation(date);
		c.setDateDernierModification(date);
		return detailProduitRepository.save(c);
	}

	@Override
	public void deleteDetailProduit(Long id) {
		detailProduitRepository.deleteById(id);
	}

	@Override
	public DetailProduit updateDetailProduit(DetailProduit c) {
		return detailProduitRepository.save(c);
	}

	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
		DetailProduit detailProduit = detailProduitRepository.findById(id).orElse(null);
		return detailProduit;
	}

}
