package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Livre;
import com.ensah.core.dao.ILivreDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class LivreDaoImpl extends HibernateSpringGenericDaoImpl<Livre, Long> implements ILivreDao{

	public LivreDaoImpl() {
		super(Livre.class);
	}

	
	
}
