package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.detailProduit;
import com.example.demo.repository.DetailProduitRepository;

@Service
public class DetailProduitServiceImpl implements DetailProduitService {

	@Autowired
	DetailProduitRepository detailProduitRepository;

	@Override
	public List<detailProduit> retrieveAllDetailProduit() {
		List<detailProduit> detailProduits = (List<detailProduit>) detailProduitRepository.findAll();
		return detailProduits;
	}

	@Override
	public detailProduit addDetailProduit(detailProduit c) {
		Date date = new Date(System.currentTimeMillis());
		c.setDateCreation(date);
		c.setDateDerniereModification(date);
		return detailProduitRepository.save(c);
	}

	@Override
	public void deleteDetailProduit(Long id) {
		detailProduitRepository.deleteById(id);
	}

	@Override
	public detailProduit updateDetailProduit(detailProduit c) {
		return detailProduitRepository.save(c);
	}

	@Override
	public detailProduit retrieveDetailProduit(Long id) {
		detailProduit detailProduit = detailProduitRepository.findById(id).orElse(null);
		return detailProduit;
	}

}
