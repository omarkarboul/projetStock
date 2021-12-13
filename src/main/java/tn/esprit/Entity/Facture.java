package tn.esprit.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Facture")
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFacture")
	private Long idFacture; // Clé primaire
	private float montantRemise;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private boolean active;
	@ManyToOne
	private Client client;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
	private Set<DetailFacture> detailsFactures;

}
