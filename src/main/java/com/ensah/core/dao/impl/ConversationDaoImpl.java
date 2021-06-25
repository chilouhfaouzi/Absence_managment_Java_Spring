package com.ensah.core.dao.impl;

import com.ensah.core.bo.Auteur;
import com.ensah.core.bo.Conversation;
import com.ensah.core.dao.IConversationDao;
import com.ensah.genericdao.GenericDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ConversationDaoImpl extends HibernateSpringGenericDaoImpl<Conversation, Long> implements IConversationDao{

	public ConversationDaoImpl() {
		super(Conversation.class);
		// TODO Auto-generated constructor stub
	}

}
