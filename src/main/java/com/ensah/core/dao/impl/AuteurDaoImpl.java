package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Auteur;
import com.ensah.core.dao.IAuteurDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class AuteurDaoImpl extends HibernateSpringGenericDaoImpl<Auteur, Long> implements IAuteurDao{

	public AuteurDaoImpl() {
		super(Auteur.class);
	}

	
	
}
