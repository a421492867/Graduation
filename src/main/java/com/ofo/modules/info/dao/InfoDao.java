package com.ofo.modules.info.dao;

import java.util.List;
import java.util.Map;

import com.ofo.modules.info.entity.Info;

public interface InfoDao {
	
	public List<Info> findByPage(Map<String, Object> params);
	
	public int getPageCount(Map<String, Object> params);
	
	public List<Info> findAll();
	
	public int getCountWithCondition(Map<String, Object> params);
	
	public List<Info> findPageByCondition(Map<String, Object> params);
	
	public int findOne(Map<String, Object> params);
	
	public int insert(Info info);
	
	public Info findById(String id);
	
	public int update(Map<String, Object> params);
	
	public int delete(Info info);
	
	public Info findLocation(String id);

}
