package tn.esprit.Service;

import java.util.Date;
import java.util.List;

import tn.esprit.Entity.Client;

public interface ClientService {

	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);

	List<Client> clientBetweenBirthDate(Date fromDate, Date toDate);
}
