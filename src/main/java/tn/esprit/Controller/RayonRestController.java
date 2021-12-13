package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Rayon;
import tn.esprit.Repository.RayonRepository;

@RestController
@RequestMapping("/rayon")
public class RayonRestController {

	@Autowired
	RayonRepository rayonRepository;

	@GetMapping("/retrieve-all-rayons")
	@ResponseBody
	public List<Rayon> getRayons() {
		List<Rayon> rayons = (List<Rayon>) rayonRepository.findAll();
		return rayons;
	}

	@GetMapping("/retrieve-rayon/{rayonId}")
	@ResponseBody
	public Rayon retrieveRayon(@PathVariable("rayonId") Long rayonId) {
		return rayonRepository.findById(rayonId).orElse(null);
	}

	@DeleteMapping("/remove-rayon/{rayonId}")
	@ResponseBody
	public void removeRayon(@PathVariable("rayonId") Long rayonId) {
		rayonRepository.deleteById(rayonId);
	}
}
