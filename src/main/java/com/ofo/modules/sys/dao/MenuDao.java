package com.ofo.modules.sys.dao;

import java.util.List;

import com.ofo.modules.sys.entity.Menu;

public interface MenuDao {
	
	public List<Menu> getMenuByRole(String roleId);
	
	public List<Menu> findChild(String parentId);

}
