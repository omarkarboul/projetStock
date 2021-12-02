package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Rayon;

public interface IRayonService {

	List<Rayon> retrieveAllRayons();

	Rayon addRayon(Rayon s);

	Rayon updateRayon(Rayon u);

	Rayon retrieveRayon(Long id);

	void deleteRayon(Long id);

}
