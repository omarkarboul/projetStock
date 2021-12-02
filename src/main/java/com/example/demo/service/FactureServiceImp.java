package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Facture;
import com.example.demo.entities.Produit;
import com.example.demo.entities.detailFacture;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DetailFactureRepository;
import com.example.demo.repository.FactureRepository;

@Service
public class FactureServiceImp implements IfactureService {

	@Autowired
	FactureRepository facturerepos;

	@Autowired
	ClientRepository clientrepos;

	@Autowired
	DetailFactureRepository detfactrepos;

	@Override
	public List<Facture> retrieveAllFactures() {

		return facturerepos.findAll();
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
		return facturerepos.save(s);
	}

	@Override
	public Facture updateFacture(Facture u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Facture retrieveFacture(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFacture(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Facture> getFacturesByClient(Long clientid) {
		return facturerepos.getFacturesByClient(clientid);
	}

}
