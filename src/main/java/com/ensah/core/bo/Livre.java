package com.ensah.core.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	
	private String codeLivre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "livre", cascade = CascadeType.ALL )
	private List<Emprunt> emprunts;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "auteur_livre",
	joinColumns = @JoinColumn(name = "id_livre"),
	inverseJoinColumns = @JoinColumn(name = "id_auteur"))
	private List<Auteur> auteurs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public String getCodeLivre() {
		return codeLivre;
	}

	public void setCodeLivre(String codeLivre) {
		this.codeLivre = codeLivre;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	} 
	
	

}
