package com.ofo.modules.bill.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.bill.dao.BillDao;
import com.ofo.modules.bill.entity.Bill;
import com.ofo.modules.bill.service.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDao billDao;
	
	@Override
	public List<Bill> findByPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Bill> billList = billDao.findByPage(params);
		return billList;
	}

	@Override
	public List<Bill> findByTpye(String type) {
		// TODO Auto-generated method stub
		List<Bill> billList = billDao.findByTpye(type);
		return billList;
	}

	@Override
	public int getPageCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int result = billDao.getPageCount(params);
		return result;
	}

}
