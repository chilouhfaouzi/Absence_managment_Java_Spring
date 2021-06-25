package com.ensah.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Auteur;
import com.ensah.core.bo.Message;
import com.ensah.core.dao.IAuteurDao;
import com.ensah.core.dao.IMessageDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;


@Repository
public class MessageDaoImp extends HibernateSpringGenericDaoImpl<Message, Long> implements IMessageDao{

	public MessageDaoImp() {
		super(Message.class);
		// TODO Auto-generated constructor stub
	} 



}
