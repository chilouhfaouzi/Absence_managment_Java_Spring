package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Emprunt;
import com.ensah.core.dao.IEmpruntDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class EmpruntDaoImpl extends HibernateSpringGenericDaoImpl<Emprunt, Long> implements IEmpruntDao{

	public EmpruntDaoImpl() {
		super(Emprunt.class);
	}

	
	
}
