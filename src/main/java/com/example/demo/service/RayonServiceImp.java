package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Rayon;
import com.example.demo.repository.RayonRepository;

@Service
public class RayonServiceImp implements IRayonService {
	
	@Autowired
	RayonRepository rayonrepository ;

	@Override
	public List<Rayon> retrieveAllRayons() {
		// TODO Auto-generated method stub
		return rayonrepository.findAll();
	}

	@Override
	public Rayon addRayon(Rayon s) {
		// TODO Auto-generated method stub
		return rayonrepository.save(s);
	}

	@Override
	public Rayon updateRayon(Rayon u) {
		// TODO Auto-generated method stub
		return rayonrepository.save(u);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		return rayonrepository.getById(id);
	}

	@Override
	public void deleteRayon(Long id) {
		// TODO Auto-generated method stub
		rayonrepository.deleteById(id);
		
	}

}
