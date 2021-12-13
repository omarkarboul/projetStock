package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.detailFacture;

public interface iDetailfactureService {

	List<detailFacture> retrieveAllDetFacts();

	detailFacture addDetFact(detailFacture s);

	detailFacture updateDetFact(detailFacture u);

	detailFacture retrieveDetFact(Long id);

	void deleteDetFact(Long id);

	void CAMagazin();

	void CAMagazinyearly();

}