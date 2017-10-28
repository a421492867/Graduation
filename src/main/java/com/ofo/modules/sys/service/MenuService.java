package com.ofo.modules.sys.service;

import java.util.List;

import com.ofo.modules.sys.entity.Menu;

public interface MenuService {
	
	//根据用户查询menu菜单
	public List<Menu> getMenuByRole(String roleId);
	
	public List<Menu> findChild(String parentId);

}
