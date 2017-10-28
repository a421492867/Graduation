package com.ofo.modules.info.service;

import java.util.List;
import java.util.Map;

import com.ofo.modules.info.entity.Info;

public interface InfoService {
	
	public List<Info> findByPage(Map<String, Object> params);
	
	public int getPageCount(Map<String, Object> params);
	
	public List<Info> findAll();
	
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
	public List<Info> findPageByCondition(Map<String, Object> params);
	
	/**
	 * 查询一条数据
	 * @param params
	 * @return
	 */
	public int findOne(Map<String, Object> params);
	
	/**
	 * 增加
	 * @param info
	 * @return
	 */
	public int insert(Info info);
	
	/**
	 * 通过Id查询一个实体
	 * @param id
	 * @return
	 */
	public Info findById(String id);
	
	/**
	 * 更新
	 * @param params
	 * @return
	 */
	public int update(Map<String, Object> params);
	
	/**
	 * 删除
	 * @param info
	 * @return
	 */
	public int delete(Info info);
	
	/**
	 * 查询经度纬度
	 * @param id
	 * @return
	 */
	public Info findLocation(String id);

}
