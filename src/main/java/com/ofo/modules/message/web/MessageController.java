package com.ofo.modules.message.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ofo.modules.message.entity.Message;
import com.ofo.modules.message.service.MessageService;

@Controller
@RequestMapping(value="message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(params="init")
	public ModelAndView get(){
		ModelAndView view = new ModelAndView("modules/message/user_message");
		List<Message> messageList = messageService.findMessage();
		for(int i = 0; i < messageList.size(); i++){
			Date crateDate = messageList.get(i).getCreateDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String convertDate = sdf.format(crateDate);
			messageList.get(i).setConvertData(convertDate);
		}
		view.addObject("messageList", messageList);
		return view;
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public boolean delete(int id){
		
		return true;
	}

}
