package tn.esprit.Service;

import java.util.List;

import tn.esprit.Entity.Facture;
import tn.esprit.Entity.Reclamation;

public interface ReclamationService {

	List<Reclamation> retrieveAllReclamations();

	Reclamation addReclamation(Reclamation c);

	void deleteReclamation(Long id);

	Reclamation updateReclamation(Reclamation c);

	Reclamation retrieveReclamation(Long id);
	
	List<Reclamation> getReclamationsByIdFournisseur(Long idFournisseur);
}
