package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Inscription;
import com.ensah.core.bo.Livre;
import com.ensah.core.dao.IAbsenceDao;
import com.ensah.core.dao.IInscriptionDao;
import com.ensah.core.services.IAbsenceService;
import com.ensah.genericdao.EntityNotFoundException;

@Service
@Transactional
public class AbsenceServiceImpl implements IAbsenceService {
	
	@Autowired
	private IAbsenceDao absenceDao;
	
	@Autowired
	private IInscriptionDao inscriptionDao;
	
	

	@Override
	public List<Absence> getAbsenceByIns(Long idInsc)  throws EntityNotFoundException{
		
		System.out.println("from service id =  "+ idInsc);

//		Inscription inscription = inscriptionDao.findById(Long.parseLong(idInsc));
//		List<Absence> listAbsencesByins = absenceDao.getEntityByColValue("Absence", "inscription", inscription.getIdInscription().toString() );
		List<Absence> listAbsencesByins = absenceDao.getEntityByColValue("Absence", "idInscription", idInsc  );
		if (listAbsencesByins.isEmpty()) {
			throw new EntityNotFoundException("Le idInsc avec le code " + idInsc + " est introuvable");
		}

		return  listAbsencesByins;
//	return absenceDao.getAll();
	}

	@Override
	public Absence getAbsenceById(Long id) {
		// TODO Auto-generated method stub
		return absenceDao.findById(id);
	}

	
}
