package com.ensah.core.web.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Inscription;
import com.ensah.core.bo.Matiere;
import com.ensah.core.bo.PieceJustificative;
import com.ensah.core.bo.TypeSeance;

public class AbsenceModel {

	private Date dateHeureDebutAbsence;
	
	private Date dateHeureFinAbsence;
	
	private int etat;
	
	private String typeSaisie;
	
	private Matiere matiere;
	
	private Set<PieceJustificative> pieceJustificative;
	
	private Inscription inscription;
	
	private TypeSeance typeSeance;

	private Enseignant observateur;

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
