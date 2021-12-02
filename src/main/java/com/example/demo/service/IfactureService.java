package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Facture;


public interface IfactureService {

	List<Facture> retrieveAllFactures();

	Facture addFacture(Facture s,Long clientid);

	Facture updateFacture(Facture u);

	Facture retrieveFacture(Long id);
	
	void deleteFacture(Long id);
	
	List<Facture> getFacturesByClient(Long clientid);
	
	
	
}
