package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entities.detailFacture;
import com.example.demo.repository.DetailFactureRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DetailFactServiceImp implements IdetailfactureService {
	
	@Autowired
	DetailFactureRepository detfactrepos ;

	@Override
	public List<detailFacture> retrieveAllDetFacts() {
		// TODO Auto-generated method stub
		return detfactrepos.findAll();
	}

	@Override
	public detailFacture addDetFact(detailFacture s) {
		// TODO Auto-generated method stub
		return detfactrepos.save(s);
	}

	@Override
	public detailFacture updateDetFact(detailFacture u) {
		// TODO Auto-generated method stub
		return detfactrepos.save(null);
	}

	@Override
	public detailFacture retrieveDetFact(Long id) {
		// TODO Auto-generated method stub
		return detfactrepos.getById(id);
	}

	@Override
	public void deleteDetFact(Long id) {
		detfactrepos.deleteById(id);
		
	}

	@Override
	//@Scheduled(cron = "@monthly")
	@Scheduled(cron = "0 0 0 1 * *")
	public void CAMagazin() {
		float ca = detfactrepos.CAmagazin();
		log.info("le chiffre f'affaire est : "+ca);
		
	}

	
	@Override
	@Scheduled(cron = "@yearly")
	public void CAMagazinyearly() {
		float ca = detfactrepos.CAmagazin();
		log.info("le chiffre f'affaire est : "+ca);
		
	}

	
	


	
	

}
