package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class Fournisseur implements Serializable{
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idFournisseur") 
	private Long idFournisseur; // Clé primaire
	
	private String code;
	private String libelle;
	
	
//	@ManyToMany(mappedBy = "fournisseurs")
//    private List<Produit> produits;
	

}
