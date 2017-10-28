package com.ofo.modules.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.sys.dao.MenuDao;
import com.ofo.modules.sys.entity.Menu;
import com.ofo.modules.sys.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<Menu> getMenuByRole(String roleId) {
		// TODO Auto-generated method stub
		List<Menu> menuList = menuDao.getMenuByRole(roleId);
		return menuList;
	}

	@Override
	public List<Menu> findChild(String parentId) {
		// TODO Auto-generated method stub
		List<Menu> childList = menuDao.findChild(parentId);
		return childList;
	}

}
