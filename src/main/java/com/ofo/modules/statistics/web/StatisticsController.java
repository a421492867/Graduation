package com.ofo.modules.statistics.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ofo.modules.message.entity.MessageType;
import com.ofo.modules.message.service.MessageService;
import com.ofo.modules.message.service.MessageTypeService;
import com.ofo.modules.statistics.service.RentRecordService;
import com.ofo.modules.statistics.service.RepairRecordService;

@Controller
@RequestMapping(value="statistics")
public class StatisticsController {
	
	@Autowired
	private MessageTypeService messageTypeService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private RepairRecordService recordService;
	
	@Autowired
	private RentRecordService rentService;
	
	@RequestMapping(params="init")
	public String get(){
		return "modules/statistics/statistics";
	}
	
	
	@RequestMapping(value="getUserMessage")
	@ResponseBody
	public Map<String,Object> getUserMessage(){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		List<MessageType> messageTypeList = messageTypeService.findMessageType();
		for(int i = 0; i < messageTypeList.size(); i++){
			MessageType entity = messageTypeList.get(i);
			int messageType = entity.getId();
			int count = messageService.findMessageCountById(messageType);
			resultMap.put(entity.getName(), count);
		}
		return resultMap;
	}
	
	@RequestMapping(value="getRepairCount")
	@ResponseBody
	public Map<String, Object> getRepairCount(){
		Map<String, Object> resultMap = recordService.getCount();
		return resultMap;
	}
	
	@RequestMapping(value="getRentCount")
	@ResponseBody
	public Map<String, Object> getRentCount(){
		Map<String, Object> resultMap = rentService.getCount();
		return resultMap;
	}

}
