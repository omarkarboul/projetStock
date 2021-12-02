package com.example.demo.service;

import java.util.Date;  
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;
import com.example.demo.entities.Facture;
import com.example.demo.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;





@Service
@Slf4j
public class ClientServiceImp implements IclientService {
	
	@Autowired
	private ClientRepository clientrepository;
	
	@Override
	public List<Client> retriveAllClients() {
		
		log.info("method works");
		return clientrepository.findAll();
		
		
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		clientrepository.save(c);
		return c;
		
	}

	@Override
	public void deleteClient(Long id) {
		clientrepository.deleteById(id);
		
	}

	@Override
	public Client updateclient(Client c) {
		clientrepository.save(c);
		return c;
	}

	@Override
	public Client retriveClient(Long id) {
		
		return clientrepository.findById(id).get();
	}


	@Override
	public List<Client> ClientsWithDateBirth(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return clientrepository.ClientsWithDateBirth(d1,d2);
	}

	@Override
	public float CAbyCategorieCategorieClient(CategorieClient categorie, Date d1, Date d2) {
		List<Facture> lst = clientrepository.CAbyCategorieCategorieClient(categorie, d1, d2);
		float x = 0 ;
		for(Facture f : lst) {
			x+=f.getMontantFacture();
		}
		return x;
	}

	


}
