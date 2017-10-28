package com.ofo.modules.info.service;

import java.util.List;
import java.util.Map;

import com.ofo.modules.fault.vo.StatusVO;
import com.ofo.modules.info.entity.Status;

public interface StatusService {
	
	/**
	 * 分页查询所有
	 * @param params
	 * @return
	 */
	public List<Status> findByPage(Map<String, Object> params);
	
	/**
	 * 分页查询所有couunt
	 * @param params
	 * @return
	 */
	public int getPageCount(Map<String, Object> params);
	
	
	/**
	 * 有条件的查询count
	 * @param params
	 * @return
	 */
	public int getCountWithCondition(Map<String, Object> params);
	
	/**
	 * 有条件的查询Page
	 * @param params
	 * @return
	 */
	public List<Status> findPageByCondition(Map<String, Object> params);
	
	
	/**
	 * 增加
	 * @param status
	 * @return
	 */
	public int insert(Status status);
	
	/**
	 * 通过Id查询一个实体
	 * @param id
	 * @return
	 */
	public Status findById(String id);
	
	/**
	 * 更新
	 * @param params
	 * @return
	 */
	public int update(Map<String, Object> params);
	
	/**
	 * 删除
	 * @param status
	 * @return
	 */
	public int delete(Status status);
	
	
	public List<StatusVO> findPageByStatus(Map<String, Object> params);
	
	public int getPageCountByStatus(Map<String, Object> params);
	
	public StatusVO findVoById(int id);
	


}
