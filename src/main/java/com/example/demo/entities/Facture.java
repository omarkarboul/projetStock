package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity 
@Table( name = "Facture") 
public class Facture implements Serializable {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idFacture") 
	private Long idFacture; // Clé primaire 
	
	private float montantRemise ;
	private float montantFacture;
	@Temporal(TemporalType.DATE) 
	private Date dateFacture;
	
	private boolean active ;

	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="clientId")
    private Client client;
	
	@JsonIgnore
	@OneToMany(mappedBy = "facture")
	private List<detailFacture> detfactures;
}
