package tn.esprit.Service;

import java.util.List;

import tn.esprit.Entity.Fournisseur;

public interface FournisseurService {

	
	List<Fournisseur> retrieveAllFournisseurs();

	void cancelFournisseur(Long id);

	Fournisseur retrieveFournisseur(Long id);

	Fournisseur findbyId(Long id);
	Fournisseur addFournisseur(Fournisseur f);
	 
	Fournisseur updateFournisseur(Fournisseur f);
	
	
}
