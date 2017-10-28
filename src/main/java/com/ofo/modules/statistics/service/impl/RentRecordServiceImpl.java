package com.ofo.modules.statistics.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.statistics.dao.RentRecordDao;
import com.ofo.modules.statistics.service.RentRecordService;

@Service
public class RentRecordServiceImpl implements RentRecordService {

	@Autowired
	private RentRecordDao rentRecordDao;
	@Override
	public Map<String, Object> getCount() {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap = rentRecordDao.getCount();
		return resultMap;
	}

}
