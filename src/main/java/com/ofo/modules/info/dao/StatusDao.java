package com.ofo.modules.info.dao;

import java.util.List;
import java.util.Map;

import com.ofo.modules.fault.vo.StatusVO;
import com.ofo.modules.info.entity.Status;


public interface StatusDao {
	
	public List<Status> findByPage(Map<String, Object> params);
	
	public int getPageCount(Map<String, Object> params);
	
	public int getCountWithCondition(Map<String, Object> params);
	
	public List<Status> findPageByCondition(Map<String, Object> params);
	
	public int insert(Status status);
	
	public Status findById(String id);
	
	public int update(Map<String, Object> params);
	
	public int delete(Status status);
	
	public List<StatusVO> findPageByStatus(Map<String, Object> params);
	
	public int getPageCountByStatus(Map<String, Object> params);
	
	public StatusVO findVoById(int id);
	

}
