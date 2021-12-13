package tn.esprit.Service;

import java.util.List;

import tn.esprit.Entity.Facture;

public interface FactureService {

	List<Facture> retrieveAllFactures();

	void cancelFacture(Long id);

	Facture retrieveFacture(Long id);

	float chiffreAffaire();
	
	Facture addFacture(Facture f, Long idClient);
	
	List<Facture> getFactureByClient(Long idclient);

}
