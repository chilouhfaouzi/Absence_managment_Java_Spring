package com.ensah.core.bo;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Absence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAbsence;

	private Date dateHeureDebutAbsence;

	private Date dateHeureFinAbsence;

	private int etat;

	private String typeSaisie;
	
	@ManyToOne
	@JoinColumn(name = "idMatiere")
	private Matiere matiere;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( joinColumns = @JoinColumn(name="idAbsence"),
				inverseJoinColumns = @JoinColumn(name="idPieceJustificative"))
	private Set<PieceJustificative> pieceJustificative;

	@ManyToOne
	@JoinColumn(name = "idInscription")
	private Inscription inscription;

	@ManyToOne
	@JoinColumn(name = "idTypeSeance")
	private TypeSeance typeSeance;
	
	@ManyToOne
	@JoinColumn(name = "idEnseignat")
	private Enseignant observateur;

	public Long getIdAbsence() {
		return idAbsence;
	}

	public void setIdAbsence(Long idAbsence) {
		this.idAbsence = idAbsence;
	}

	public Date getDateHeureDebutAbsence() {
		return dateHeureDebutAbsence;
	}

	public void setDateHeureDebutAbsence(Date dateHeureDebutAbsence) {
		this.dateHeureDebutAbsence = dateHeureDebutAbsence;
	}

	public Date getDateHeureFinAbsence() {
		return dateHeureFinAbsence;
	}

	public void setDateHeureFinAbsence(Date dateHeureFinAbsence) {
		this.dateHeureFinAbsence = dateHeureFinAbsence;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public String getTypeSaisie() {
		return typeSaisie;
	}

	public void setTypeSaisie(String typeSaisie) {
		this.typeSaisie = typeSaisie;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Set<PieceJustificative> getPieceJustificative() {
		return pieceJustificative;
	}

	public void setPieceJustificative(Set<PieceJustificative> pieceJustificative) {
		this.pieceJustificative = pieceJustificative;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	public TypeSeance getTypeSeance() {
		return typeSeance;
	}

	public void setTypeSeance(TypeSeance typeSeance) {
		this.typeSeance = typeSeance;
	}

	public Enseignant getObservateur() {
		return observateur;
	}

	public void setObservateur(Enseignant observateur) {
		this.observateur = observateur;
	}

	
}