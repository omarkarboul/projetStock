package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "detailFacture")
public class detailFacture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailFacture")
	private Long idDetailFacture; // Clé primaire

	private int qte;
	private float prixTotal;
	private int pourcentageRemise;
	private float montantremise;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "FactureId")
	private Facture facture;

	@ManyToOne
	@JoinColumn(name = "produitId")
	private Produit produit;

}
