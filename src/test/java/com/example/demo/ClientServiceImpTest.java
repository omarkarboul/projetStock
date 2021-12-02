package com.example.demo;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entities.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.IclientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImpTest {
	
	@Autowired
	ClientRepository clientrepos;
	@Autowired
	IclientService iclientservice;
	
	@Test
	public void ClientsWithDateBirthTest() {
		Date d1 = new Date();
		Date d2 = new Date();
		List<Client> clients = iclientservice.ClientsWithDateBirth(d1,d2);
		assertNotNull(clients.size());
	}

}
