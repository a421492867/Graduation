package com.ofo.modules.info.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.fault.vo.StatusVO;
import com.ofo.modules.info.dao.StatusDao;
import com.ofo.modules.info.entity.Status;
import com.ofo.modules.info.service.StatusService;


@Service
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private StatusDao statusDao;
	
	@Override
	public List<Status> findByPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Status> statusList = statusDao.findByPage(params);
		return statusList;
	}

	@Override
	public int getPageCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int count = statusDao.getPageCount(params);
		return count;
	}

	@Override
	public int getCountWithCondition(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int count = statusDao.getCountWithCondition(params);
		return count;
	}

	@Override
	public List<Status> findPageByCondition(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<Status> statusList = statusDao.findPageByCondition(params);
		return statusList;
	}

	@Override
	public int insert(Status status) {
		// TODO Auto-generated method stub
		int result = statusDao.insert(status);
		return result;
	}

	@Override
	public Status findById(String id) {
		// TODO Auto-generated method stub
		Status status = statusDao.findById(id);
		return status;
	}

	@Override
	public int update(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int result = statusDao.update(params);
		return result;
	}

	@Override
	public int delete(Status status) {
		// TODO Auto-generated method stub
		int result = statusDao.delete(status);
		return result;
	}

	@Override
	public List<StatusVO> findPageByStatus(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<StatusVO> statusVOList = statusDao.findPageByStatus(params);
		return statusVOList;
	}

	@Override
	public int getPageCountByStatus(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int count = statusDao.getPageCountByStatus(params);
		return count;
	}

	@Override
	public StatusVO findVoById(int id) {
		// TODO Auto-generated method stub
		StatusVO statusVo = statusDao.findVoById(id);
		return statusVo;
	}
	

	
	


}
