package com.ofo.modules.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.message.dao.MessageDao;
import com.ofo.modules.message.entity.Message;
import com.ofo.modules.message.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageDao messageDao;

	@Override
	public List<Message> findMessage() {
		// TODO Auto-generated method stub
		List<Message> messageList = messageDao.findMessage();
		return messageList;
	}

	@Override
	public int findMessageCountById(int messageType) {
		// TODO Auto-generated method stub
		int count = messageDao.findMessageCountById(messageType);
		return count;
	}

}
