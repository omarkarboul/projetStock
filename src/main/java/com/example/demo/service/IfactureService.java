package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Facture;
import com.example.demp.dto.PaymentInfo;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;


public interface IfactureService {

	List<Facture> retrieveAllFactures();

	Facture addFacture(Facture s,Long clientid);

	Facture updateFacture(Facture u);

	Facture retrieveFacture(Long id);
	
	void deleteFacture(Long id);
	
	List<Facture> getFacturesByClient(Long clientid);
	
	PaymentIntent createPaymentIntent(PaymentInfo paymentinfo) throws StripeException ;
	
	
	
}
