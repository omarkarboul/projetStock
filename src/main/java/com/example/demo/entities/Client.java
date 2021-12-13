package com.example.demo.entities;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "Client")
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClient")
	private Long idClient; // Clé primaire
	private String nom;
	private String prenom;
	private String email;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Enumerated(EnumType.STRING)
	private Profession profession;
	@Enumerated(EnumType.STRING)
	private CategorieClient categorieClient;
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Facture> factures;

}