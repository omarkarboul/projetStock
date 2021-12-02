package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Rayon;
import com.example.demo.service.IRayonService;

@Controller
@RequestMapping("/rayon")
public class RayonController {

	@Autowired
	IRayonService rayonservice;

	@GetMapping("/retrieve-all-rayons")
	@ResponseBody
	public List<Rayon> getRayons() {
		return rayonservice.retrieveAllRayons();
	}

	@GetMapping("/retrieve-rayon/{rayon-id}")
	@ResponseBody
	public Rayon retrieveRayon(@PathVariable("rayon-id") Long RayonId) {
		return rayonservice.retrieveRayon(RayonId);
	}

	// http://localhost:8089/SpringMVC/client/add-client
	@PostMapping("/add-rayon")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon s) {

		return rayonservice.addRayon(s);
	}

	@PutMapping("/update-rayon")
	@ResponseBody
	public Rayon updateRayon(@RequestBody Rayon s) {
		return rayonservice.updateRayon(s);
	}

	@DeleteMapping("/remove-stock/{rayon-id}")
	@ResponseBody
	public void deleteRayon(@PathVariable("rayon-id") Long rayonId) {
		rayonservice.deleteRayon(rayonId);
	}

}
