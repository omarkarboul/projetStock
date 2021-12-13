package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Facture;

public interface iFactureService {

	List<Facture> retrieveAllFactures();

	void cancelFacture(Long id);

	Facture retrieveFacture(Long id);

	float chiffreAffaire();

	Facture addFacture(Facture f, Long idClient);

	List<Facture> getFactureByClient(Long idclient);
}
