package com.ensah.core.services;

import com.ensah.core.bo.Conversation;

public interface IConversationService {
	
	public void addConversation(Conversation conv);
	
	public Conversation getConversation(Long id);

}
