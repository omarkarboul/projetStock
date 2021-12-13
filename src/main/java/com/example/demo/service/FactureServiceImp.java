package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Facture;
import com.example.demo.entities.Produit;
import com.example.demo.entities.detailFacture;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DetailFactureRepository;
import com.example.demo.repository.FactureRepository;

@Service
public class FactureServiceImp implements iFactureService {

	@Autowired
	FactureRepository factureRepository;

	@Autowired
	ClientRepository clientrepos;

	@Autowired
	DetailFactureRepository detfactrepos;

	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		return factures;
	}

	@Transactional
	public Facture addFacture(Facture s, Long clientid) {
		s.setClient(clientrepos.getById(clientid));
		List<detailFacture> ls = s.getDetfactures();
		float montantremise = 0;
		float montantfacture = 0;
		for (detailFacture df : ls) {
			float tot = 0;
			Produit p = df.getProduit();
			tot += p.getPrixUnitaire() * df.getQte();
			float montrem = tot * df.getPourcentageRemise();
			float monttot = tot - montrem;
			df.setMontantremise(montrem);
			df.setPrixTotal(monttot);
			montantremise += montrem;
			montantfacture += monttot;
			detfactrepos.save(df);
		}
		s.setMontantFacture(montantfacture);
		s.setMontantRemise(montantremise);
		return factureRepository.save(s);
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
		return factureRepository.getFacturesByClient(idclient);
	}
}
