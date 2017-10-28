package com.ofo.modules.sys.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ofo.modules.sys.entity.User;

public interface UserService {
	
	public User selectByName(String userName);
	
	public Set<String> findRoles(String userName);
	
	public Set<String> findPermissions(String userName);
	
	public List<User> findUserByLocation(String userLocation);
	
	public List<User> findByPage(Map<String, Object> params);
	
	public int getPageCount(Map<String, Object> params);
	
	public int findOne(Map<String, Object> params);
	
	public int insert(User user);
	
	public int delete(User user);
	
	public User findById(String id);
	
	public int updateByRoot(Map<String, Object> params);

}
