package com.ensah.core.services;

import com.ensah.core.bo.Message;

public interface IMessageService {

	public void addMessage(Message msg);
	public Message getMessage(Long id);

	
}
