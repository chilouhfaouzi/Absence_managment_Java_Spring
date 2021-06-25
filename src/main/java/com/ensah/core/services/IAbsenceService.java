package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Utilisateur;

public interface IAbsenceService {

	
	public  List<Absence> getAbsenceByIns(Long idInsc) ;
	
	public Absence getAbsenceById(Long id);
}
