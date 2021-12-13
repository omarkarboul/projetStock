package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.CategorieClient;
import com.example.demo.entities.Client;
import com.example.demo.service.iClientService;
import com.example.demo.service.date12;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client")
public class ClientController {

	@Autowired
	iClientService clientService;

	// http://localhost:8089/SpringMVC/client/retrieve-all-clients
	@GetMapping("/retrieve-all-clients")
	@ResponseBody
	public List<Client> getClients() {
		List<Client> listClients = clientService.retriveAllClients();
		return listClients;
	}

	@GetMapping("/retrieve-client/{client-id}")
	@ResponseBody
	public Client retrieveClient(@PathVariable("client-id") Long clientId) {
		return clientService.retriveClient(clientId);
	}

	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-client")
	@ResponseBody
	public Client addClient(@RequestBody Client c) {
		Client client = clientService.addClient(c);
		return client;
	}

	// http://localhost:8089/SpringMVC/client/remove-client/{client-id}
	@DeleteMapping("/remove-client/{client-id}")
	@ResponseBody
	public void removeClient(@PathVariable("client-id") Long clientId) {
		clientService.deleteClient(clientId);
	}

	// http://localhost:8089/SpringMVC/client/modify-client
	@PutMapping("/modify-client")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client) {
		return clientService.updateclient(client);
	}

	@GetMapping("/CAparcategorieclient/{categorie}")
	@ResponseBody
	public float CAparCategorieClient(@RequestBody date12 date, @PathVariable("categorie") CategorieClient categorie) {
		return clientService.chiffreAffaireCategClient(categorie, date.getDate1(), date.getDate2());
	}

	// project

	@GetMapping("/getAchatTotal/{idClient}")
	@ResponseBody
	public float getAchatTotal(@PathVariable("idClient") Long idClient) {
		return clientService.getAchatTotal(idClient);
	}

	@GetMapping("/getPorduitAchete/{idClient}")
	@ResponseBody
	public int getPorduitAchete(@PathVariable("idClient") Long idClient) {
		return clientService.getPorduitAchete(idClient);
	}

	@GetMapping("/getPorduitAcheteInfDate/{idClient}/{date}")
	@ResponseBody
	public float getPorduitAcheteInfDate(@PathVariable("idClient") Long idClient, @PathVariable("date") Date date) {
		return clientService.getPorduitAcheteInfDate(idClient, date);
	}
}
