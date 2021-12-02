package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Rayon;
import com.example.demo.repository.RayonRepository;

@Service
public class RayonServiceImp implements IRayonService {

	@Autowired
	RayonRepository rayonrepository;

	@Override
	public List<Rayon> retrieveAllRayons() {
		return rayonrepository.findAll();
	}

	@Override
	public Rayon addRayon(Rayon s) {
		return rayonrepository.save(s);
	}

	@Override
	public Rayon updateRayon(Rayon u) {
		return rayonrepository.save(u);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		return rayonrepository.getById(id);
	}

	@Override
	public void deleteRayon(Long id) {
		rayonrepository.deleteById(id);

	}

}
