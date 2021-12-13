package tn.esprit.Service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.Client;
import tn.esprit.Entity.DetailFacture;
import tn.esprit.Entity.Facture;
import tn.esprit.Entity.Produit;
import tn.esprit.Repository.ClientRepository;
import tn.esprit.Repository.DetailFactureRepository;
import tn.esprit.Repository.FactureRepository;

@Service
public class FactureServiceImpl implements FactureService {

	@Autowired
	FactureRepository factureRepository;
	@Autowired
	DetailFactureRepository detailFactureRepository;
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		return factures;
	}

	@Override
	public void cancelFacture(Long id) {
		Facture facture = factureRepository.findById(id).orElse(null);
		if (facture.isActive() == false) {
			factureRepository.deleteById(id);
		}

	}

	@Override
	public Facture retrieveFacture(Long id) {
		Facture facture = factureRepository.findById(id).orElse(null);
		return facture;
	}

	@Scheduled(cron = "0 0 0 1/1 * *")
	public float chiffreAffaire() {
		float chiffreAffaire = 0;
		List<Facture> factures = factureRepository.chiffreAffaire();
		for (Facture facture : factures) {
			chiffreAffaire = chiffreAffaire + facture.getMontantFacture();
		}
		return chiffreAffaire;
	}

	@Override
	public List<Facture> getFactureByClient(Long idclient) {
		return factureRepository.getFactureByClient(idclient);
	}

	@Transactional
	public Facture addFacture(Facture f, Long idClient) {
		Client client = clientRepository.findById(idClient).orElse(null);
		client.getFactures().add(f);
		float montantFacture = 0;
		float montantRemise = 0;
		Set<DetailFacture> detailFactures = f.getDetailsFactures();
		for (DetailFacture detail : detailFactures) {
			Produit produit = detail.getProduit();
			float prix = detail.getQte() * produit.getPrixUnitaire();
			float prixRemise = prix * detail.getPourcentageRemise();
			float MontantRemise = prix - prixRemise;
			detail.setMontantRemise(montantRemise);
			detail.setPrixTotal(prixRemise);
			montantFacture += prixRemise;
			montantRemise += MontantRemise;
			detailFactureRepository.save(detail);
		}
		f.setMontantFacture(montantFacture);
		f.setMontantRemise(montantRemise);
		return factureRepository.save(f);
	}

}
