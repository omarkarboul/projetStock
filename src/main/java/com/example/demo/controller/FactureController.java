package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.PaymentInfo;
import com.example.demo.entities.Facture;
import com.example.demo.entities.Stock;
import com.example.demo.service.IfactureService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

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
	
	@PostMapping("/payment-intent")
	public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentinfo) throws StripeException{
		PaymentIntent pi = factureservice.createPaymentIntent(paymentinfo);
		String paymentstr = pi.toJson();
		return new ResponseEntity<>(paymentstr, HttpStatus.OK);
	}

}
