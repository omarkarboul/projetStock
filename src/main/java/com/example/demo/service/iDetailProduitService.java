package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.detailProduit;

public interface iDetailProduitService {

	List<detailProduit> retrieveAllDetailProduit();

	detailProduit addDetailProduit(detailProduit c);

	void deleteDetailProduit(Long id);

	detailProduit updateDetailProduit(detailProduit c);

	detailProduit retrieveDetailProduit(Long id);

}
