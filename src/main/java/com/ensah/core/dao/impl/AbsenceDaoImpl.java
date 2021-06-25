package com.ensah.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Compte;
import com.ensah.core.dao.IAbsenceDao;
import com.ensah.genericdao.EntityNotFoundException;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class AbsenceDaoImpl  extends HibernateSpringGenericDaoImpl<Absence, Long>  implements IAbsenceDao {

	public AbsenceDaoImpl() {
		super(Absence.class);
		// TODO Auto-generated constructor stub
	}

}
