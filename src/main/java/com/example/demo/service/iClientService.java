package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;

public interface iClientService {

	List<Client> retriveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateclient(Client c , Long idClient);

	Client retriveClient(Long id);

	List<Client> ClientsWithDateBirth(Date d1, Date d2);

	float chiffreAffaireCategClient(CategorieClient categorie, Date d1, Date d2);

	// project

	float getAchatTotal(Long idClient);

	int getPorduitAchete(Long idClient);

	int getPorduitAcheteInfDate(Long idClient, Date date);

}
