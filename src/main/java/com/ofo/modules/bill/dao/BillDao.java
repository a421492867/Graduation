package com.ofo.modules.bill.dao;

import java.util.List;
import java.util.Map;

import com.ofo.modules.bill.entity.Bill;

public interface BillDao {
	
	public List<Bill> findByPage(Map<String, Object> params);
	
	public List<Bill> findByTpye(String type);
	
	public int getPageCount(Map<String, Object> params);

}
