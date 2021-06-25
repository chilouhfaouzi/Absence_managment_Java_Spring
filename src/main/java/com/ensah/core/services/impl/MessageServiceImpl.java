package com.ensah.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Message;
import com.ensah.core.dao.IMessageDao;
import com.ensah.core.services.IMessageService;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

	@Autowired
    private IMessageDao messagedao;

	@Override
	public void addMessage(Message msg) {

		messagedao.create(msg);
	}

	@Override
	public Message getMessage(Long id) {
		// TODO Auto-generated method stub
		return messagedao.findById(id);
	}
	
	 

}
