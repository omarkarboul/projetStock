package com.example.demo.entities;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduit")
	private Long idProduit; // Clé primaire

	private String code;
	private String libelle;

	private float prixUnitaire;

	@JsonIgnore
	@OneToMany(mappedBy = "produit")
	private List<detailFacture> detfactures;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "rayonId")
	private Rayon rayon;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "StockId")
	private Stock stock;

	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "detailproduitid")
	private detailProduit detailproduit;

//	@ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "produit_fournisseur", 
//      joinColumns = @JoinColumn(name = "idFournisseur", referencedColumnName = "idFournisseur"), 
//      inverseJoinColumns = @JoinColumn(name = "produit_id", 
//      referencedColumnName = "idProduit"))
//    private List<Fournisseur> fournisseurs;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "produit_fournisseur", joinColumns = @JoinColumn(name = "idFournisseur"), inverseJoinColumns = @JoinColumn(name = "produit_id")) // @JoinTable
																																						// is
																																						// used
																																						// to
																																						// map
																																						// Join
																																						// table
																																						// in
																																						// database
	private List<Fournisseur> fournisseurs;
	
	
	private String image ;
}
