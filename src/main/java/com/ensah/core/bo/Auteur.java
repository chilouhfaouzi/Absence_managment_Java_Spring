package com.ensah.core.bo;

import java.util.List;


import javax.persistence.*;
@Entity
public class Auteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	private String prenom;
	
	@ManyToMany
	@JoinTable(name = "auteur_livre",
	joinColumns = @JoinColumn(name = "id_auteur"),
	inverseJoinColumns = @JoinColumn(name = "id_livre"))
	private List<Livre> livres;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
