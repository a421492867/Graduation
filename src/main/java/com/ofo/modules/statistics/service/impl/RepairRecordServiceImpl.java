package com.ofo.modules.statistics.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.statistics.dao.RepairRecordDao;
import com.ofo.modules.statistics.service.RepairRecordService;

@Service
public class RepairRecordServiceImpl implements RepairRecordService {

	@Autowired
	private RepairRecordDao repairRecordDao;
	
	@Override
	public Map<String, Object> getCount() {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = repairRecordDao.getCount();
		return resultMap;
	}

}
