package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Inscription;
import com.ensah.core.dao.ICompteDao;
import com.ensah.core.dao.IInscriptionDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class InscriptionDaoImpl  extends HibernateSpringGenericDaoImpl<Inscription, Long> implements IInscriptionDao {

	public InscriptionDaoImpl() {
		super(Inscription.class);
		// TODO Auto-generated constructor stub
	}
	
	


}
