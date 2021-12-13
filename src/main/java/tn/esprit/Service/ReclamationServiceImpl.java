package tn.esprit.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Entity.Reclamation;
import tn.esprit.Repository.FournisseurRepository;
import tn.esprit.Repository.ReclamationRepository;

@Service
@Slf4j
public class ReclamationServiceImpl implements ReclamationService {

	@Autowired
	ReclamationRepository reclamationRepository;
	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		return (List<Reclamation>) reclamationRepository.findAll();
	}

	@Override
	public Reclamation addReclamation(Reclamation c ) throws MailException  {
		
		c.setDateReclamation(new Date());
		System.out.println("send mail");
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(c.getFournisseur().getEmail());
		msg.setFrom("societemagazin@gmail.com");
		msg.setSubject(c.getObjet());
		msg.setText(c.getDescription());
		javaMailSender.send(msg);
		return reclamationRepository.save(c);
	}

	@Override
	public void deleteReclamation(Long id) {
		reclamationRepository.deleteById(id);
		
	}

	@Override
	public Reclamation updateReclamation(Reclamation f) {
		return reclamationRepository.save(f);
	}

	@Override
	public Reclamation retrieveReclamation(Long id) {
		Reclamation f = reclamationRepository.findById(id).orElse(null);
		return f;
	}

	@Override
	public List<Reclamation> getReclamationsByIdFournisseur(Long idFournisseur) {
		return reclamationRepository.getReclationByIdFournisseur(idFournisseur);
		
		
	}
	


}
