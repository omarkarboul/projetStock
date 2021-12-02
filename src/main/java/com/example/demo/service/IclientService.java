package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;

public interface IclientService {

	List<Client> retriveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateclient(Client c);

	Client retriveClient(Long id);

	// float getChiffreAffaireParCategorieClient(CategorieClient categorieClient );
	List<Client> ClientsWithDateBirth(Date d1, Date d2);

	float CAbyCategorieCategorieClient(CategorieClient categorie, Date d1, Date d2);

}
