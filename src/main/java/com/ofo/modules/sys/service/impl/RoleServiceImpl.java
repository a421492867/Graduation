package com.ofo.modules.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.sys.dao.RoleDao;
import com.ofo.modules.sys.entity.Role;
import com.ofo.modules.sys.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<Role> findRole() {
		// TODO Auto-generated method stub
		List<Role> roleList = roleDao.findRole();
		return roleList;
	}

}
