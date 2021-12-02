package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStock")
	private Long idStock; // Clé primaire

	private int qte;
	private int qteMin;

	private String libelleStock;

	public Stock(int qte, int qteMin, String libelleStock) {
		super();
		this.qte = qte;
		this.qteMin = qteMin;
		this.libelleStock = libelleStock;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "stock")
	private List<Produit> produits;
}
