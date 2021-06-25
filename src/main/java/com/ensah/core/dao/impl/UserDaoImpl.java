package com.ensah.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Compte;
import com.ensah.core.dao.ICompteDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class UserDaoImpl extends HibernateSpringGenericDaoImpl<Compte, Long> implements ICompteDao {

	public UserDaoImpl() {

		super(Compte.class);

	}

	public Compte findByUsername(String username) {
		List<Compte> users = getEntityByColValue("Compte", "login", username);
		return users.size() != 0
				? users.get(0)
				: null;
	}
}
