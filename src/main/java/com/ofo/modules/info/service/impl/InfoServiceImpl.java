package com.ofo.modules.info.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.info.dao.InfoDao;
import com.ofo.modules.info.entity.Info;
import com.ofo.modules.info.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoDao infoDao;
	
	public List<Info> findByPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Info> infoList = infoDao.findByPage(params);
		return infoList;
	}

	@Override
	public int getPageCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int count = infoDao.getPageCount(params);
		return count;
	}

	@Override
	public List<Info> findAll() {
		// TODO Auto-generated method stub
		List<Info> infoList = infoDao.findAll();
		return infoList;
	}

	@Override
	public int getCountWithCondition(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int count = infoDao.getCountWithCondition(params);
		return count;
	}

	@Override
	public List<Info> findPageByCondition(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Info> infoList = infoDao.findPageByCondition(params);
		return infoList;
	}

	@Override
	public int findOne(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int result = infoDao.findOne(params);
		return result;
	}

	@Override
	public int insert(Info info) {
		// TODO Auto-generated method stub
		int result = infoDao.insert(info);
		return result;
	}

	@Override
	public Info findById(String id) {
		// TODO Auto-generated method stub
		Info info = infoDao.findById(id);
		return info;
	}

	@Override
	public int update(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int result = infoDao.update(params);
		return result;
	}

	@Override
	public int delete(Info info) {
		// TODO Auto-generated method stub
		int result = infoDao.delete(info);
		return result;
	}

	@Override
	public Info findLocation(String id) {
		// TODO Auto-generated method stub
		Info info = infoDao.findLocation(id);
		return info;
	}

}
