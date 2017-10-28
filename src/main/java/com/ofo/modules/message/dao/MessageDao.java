package com.ofo.modules.message.dao;

import java.util.List;

import com.ofo.modules.message.entity.Message;

public interface MessageDao {
	
	public List<Message> findMessage();
	
	public int findMessageCountById(int messageType);

}
