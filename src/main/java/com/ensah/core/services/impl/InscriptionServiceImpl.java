package com.ensah.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Inscription;
import com.ensah.core.dao.IInscriptionDao;
import com.ensah.core.services.IInscriptionService;


@Service
@Transactional
public class InscriptionServiceImpl  implements IInscriptionService {
	
	
	@Autowired
	private IInscriptionDao inscriptionDao;

	public InscriptionServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Inscription getInscriptionByid(Long id) {
		// TODO Auto-generated method stub
		return inscriptionDao.findById(id);
	}

}
