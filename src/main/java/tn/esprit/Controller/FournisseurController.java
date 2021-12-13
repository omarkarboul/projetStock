package tn.esprit.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.Entity.Fournisseur;
import tn.esprit.Entity.Response;
import tn.esprit.Service.FournisseurService;


@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
	@Autowired
	FournisseurService FournisseurService;
	
    @Autowired
    ServletContext context;
	
	@GetMapping("/retrieve-all-Fournisseurs")
	@ResponseBody
	public List<Fournisseur> getFournisseurs() {
		List<Fournisseur> Fournisseurs = FournisseurService.retrieveAllFournisseurs();
		return Fournisseurs;
	}

	@GetMapping("/retrieve-Fournisseur/{FournisseurId}")
	@ResponseBody
	public Fournisseur retrieveFournisseur(@PathVariable("FournisseurId") Long FournisseurId) {
		return FournisseurService.retrieveFournisseur(FournisseurId);
	}

	@DeleteMapping("/remove-Fournisseur/{FournisseurId}")
	@ResponseBody
	public void cancelFournisseur(@PathVariable("FournisseurId") Long FournisseurId) {
		FournisseurService.cancelFournisseur(FournisseurId);
	}
	
	@PostMapping("/add-Fournisseur")
	public ResponseEntity<Response> addFournisseur(@RequestParam ("image") MultipartFile image , @RequestParam("fournisseur") String c)throws JsonParseException,JsonMappingException,IOException {
		Fournisseur fournisseur = new ObjectMapper().readValue(c, Fournisseur.class);
	
		boolean isExist = new File(context.getRealPath("/images/")).exists();
		if(!isExist) {
			new File (context.getRealPath("/images/")).mkdir();
		}
		String filename = image.getOriginalFilename();
		String newFilename = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
		File serverFile = new File (context.getRealPath("/images/"+File.separator+newFilename));
		try {
			FileUtils.writeByteArrayToFile(serverFile, image.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
		}
		fournisseur.setImage(newFilename);
		Fournisseur dbfourn=  FournisseurService.addFournisseur(fournisseur);
		if(dbfourn!=null) {
			return new ResponseEntity<Response>(new Response("fournisseur saved"), HttpStatus.OK);
		}else {
			return new ResponseEntity<Response>(new Response("fournisseur saved"), HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/modify-Fournisseur")
	@ResponseBody
	public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) {
		return FournisseurService.updateFournisseur(fournisseur);
	}
	@GetMapping(path="/Imgfournisseur/{id}")
	public byte[] getImg(@PathVariable("id") Long id)throws Exception{
		Fournisseur fournisseur = FournisseurService.findbyId(id);
		return Files.readAllBytes(Paths.get(context.getRealPath("/images/")+fournisseur.getImage()));
		
		
	}


}
