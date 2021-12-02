package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class detailProduit implements Serializable {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)  
	private Long idDetailProduit; // Clé primaire
	
	@Temporal(TemporalType.DATE) 
	private Date dateCreation; 
	@Temporal(TemporalType.DATE) 
	private Date dateDerniereModification;
	@Enumerated(EnumType.STRING) 
	private CategorieProduit categorieProduit;
	
	
	public detailProduit(Date dateCreation, Date dateDerniereModification, CategorieProduit categorieProduit,
			Produit produit) {
		super();
		this.dateCreation = dateCreation;
		this.dateDerniereModification = dateDerniereModification;
		this.categorieProduit = categorieProduit;
		this.produit = produit;
	}

	@JsonIgnore
	@OneToOne(mappedBy = "detailproduit")
    private Produit produit;
	
}
