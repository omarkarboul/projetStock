package tn.esprit.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.Entity.Fournisseur;
import tn.esprit.Repository.FournisseurRepository;

@Service
public class FournisseurServiceImpl implements FournisseurService{

	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		return (List<Fournisseur>) fournisseurRepository.findAll();
	}

	@Override
	public void cancelFournisseur(Long id) {
		fournisseurRepository.deleteById(id);
		
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		Fournisseur f = fournisseurRepository.findById(id).orElse(null);
		return f;
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		
		return fournisseurRepository.save(f);
		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		return fournisseurRepository.save(f);
	}

	@Override
	public Fournisseur findbyId(Long id) {
		Fournisseur f = fournisseurRepository.findById(id).orElse(null);
		return f;
	}

}
