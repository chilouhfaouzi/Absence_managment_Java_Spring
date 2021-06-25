package com.ensah.core.bo;


import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Coordination {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCoordination;

	private Date dateDebut;

	private Date dateFin;

	@ManyToOne
	@JoinColumn(name="idCoordinateur")
	public Enseignant coordonateur;

	public Long getIdCoordination() {
		return idCoordination;
	}

	public void setIdCoordination(Long idCoordination) {
		this.idCoordination = idCoordination;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Enseignant getCoordonateur() {
		return coordonateur;
	}

	public void setCoordonateur(Enseignant coordonateur) {
		this.coordonateur = coordonateur;
	}
	
	

}