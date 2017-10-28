package com.ofo.modules.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.message.dao.MessageTypeDao;
import com.ofo.modules.message.entity.MessageType;
import com.ofo.modules.message.service.MessageTypeService;

@Service
public class MessageTypeServiceImpl implements MessageTypeService {
	
	@Autowired
	private MessageTypeDao messageTypeDao;

	@Override
	public List<MessageType> findMessageType() {
		// TODO Auto-generated method stub
		List<MessageType> messageTypeList = messageTypeDao.findMessageType();
		return messageTypeList;
	}

}
