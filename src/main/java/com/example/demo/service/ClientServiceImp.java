package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;
import com.example.demo.entities.Facture;
import com.example.demo.entities.detailFacture;
import com.example.demo.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImp implements iClientService {

	@Autowired
	private ClientRepository clientrepository;

	Pageable paging = PageRequest.of(0, 3);

	public List<Client> ListfindAll(Pageable paging) {
		Page<Client> recordsPage = clientrepository.findAll(paging);
		return recordsPage.getContent();
	}

	@Override
	public List<Client> retriveAllClients() {
		List<Client> Clients = ListfindAll(paging);
		return Clients;
	}

	@Override
	public Client addClient(Client c) {
		return clientrepository.save(c);
	}

	@Override
	public void deleteClient(Long id) {
		clientrepository.deleteById(id);

	}

	@Override
	public Client updateclient(Client c) {
		return clientrepository.save(c);
	}

	@Override
	public Client retriveClient(Long id) {

		return clientrepository.findById(id).get();
	}

	@Override
	public List<Client> ClientsWithDateBirth(Date d1, Date d2) {
		return clientrepository.ClientsWithDateBirth(d1, d2);
	}

	@Override
	public float chiffreAffaireCategClient(CategorieClient categorie, Date d1, Date d2) {
		List<Facture> clients = clientrepository.chiffreAffaireCategClient(categorie, d1, d2);
		float chiffreAffaire = 0;
		for (Facture client : clients) {
			chiffreAffaire += client.getMontantFacture();
		}
		return chiffreAffaire;
	}

	// project

	@Override
	public float getAchatTotal(Long idClient) {
		float achatTotal = 0;
		List<Facture> factures = clientrepository.getAchatTotal(idClient);
		for (Facture facture : factures) {
			achatTotal += facture.getMontantFacture();
		}
		return achatTotal;
	}

	@Override
	public int getPorduitAchete(Long idClient) {
		List<Facture> factures = clientrepository.getPorduitAchete(idClient);
		int produits = 0;
		for (Facture facture : factures) {
			List<detailFacture> detailFactures = facture.getDetfactures();
			for (detailFacture detailfact : detailFactures) {
				produits += detailfact.getQte();
			}
		}
		return produits;
	}

	@Override
	public int getPorduitAcheteInfDate(Long idClient, Date date) {
		List<Facture> factures = clientrepository.getPorduitAchetéParDate(idClient, date);
		int produits = 0;
		for (Facture facture : factures) {
			List<detailFacture> detailFactures = facture.getDetfactures();
			for (detailFacture detailfact : detailFactures) {
				produits += detailfact.getQte();
			}
		}
		return produits;
	}

}
