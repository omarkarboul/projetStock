package tn.esprit.Service;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.Client;
import tn.esprit.Repository.ClientRepository;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		List<Client> Clients = (List<Client>) clientRepository.findAll();
		for (Client client : Clients) {
			log.info("Client" + client);
		}
		return Clients;
	}

	@Override
	public Client addClient(Client c) {

		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);

	}

	@Override
	public Client updateClient(Client c) {

		return clientRepository.save(c);
	}

	@Override
	public Client retrieveClient(Long id) {
		Client client = clientRepository.findById(id).orElse(null);
		return client;
	}

	@Override
	public List<Client> clientBetweenBirthDate(Date fromDate, Date toDate) {

		return clientRepository.findBetweenDateNaissance(fromDate, toDate);
	}
	

}
