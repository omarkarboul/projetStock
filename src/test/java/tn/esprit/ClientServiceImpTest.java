package tn.esprit;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.Entity.Client;
import tn.esprit.Repository.ClientRepository;
import tn.esprit.Service.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImpTest {

	@Autowired
	ClientService clientService;
	@Autowired
	ClientRepository clientRepository;

	@Test
	public void clientDateBirth() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/yy/yyyy");
		Date startDate = dateFormat.parse("01/01/1995");
		Date toDate = dateFormat.parse("31/12/1995");
		List<Client> clients = clientService.clientBetweenBirthDate(startDate, toDate);
		assertNotNull(clients.size());
	}
}
