package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Rayon implements Serializable {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idRayon") 
	private Long idRayon; // Clé primaire
	
	private String code;
	private String libelle;
	
	
	@OneToMany(mappedBy = "rayon")
	private List<Produit> produits;

}
