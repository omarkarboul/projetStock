package tn.esprit.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "Fournisseur")
public class Fournisseur   {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFournisseur")
	private Long idFournisseur; // Clé primaire
	private String code;
	private String libelle;
	private String adresse;
	private String numtel;
	private String image;
	private String email;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fournisseur")
	private Set<Reclamation> reclamations;
}
