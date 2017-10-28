package com.ofo.modules.message.service;

import java.util.List;

import com.ofo.modules.message.entity.Message;

public interface MessageService {
	
	public List<Message> findMessage();
	
	public int findMessageCountById(int messageType);

}
