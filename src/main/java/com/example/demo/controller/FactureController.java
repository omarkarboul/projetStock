package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Facture;
import com.example.demo.entities.Stock;
import com.example.demo.service.IfactureService;

@Controller
@RequestMapping("/facture")
public class FactureController {
	
	@Autowired
	IfactureService factureservice ;

	@GetMapping("/getfacturesbyclient/{client-id}")
	@ResponseBody
	public List<Facture> getFacturesByClient(@PathVariable("client-id") Long clientid){
		return factureservice.getFacturesByClient(clientid);
	}

}
