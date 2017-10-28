package com.ofo.modules.sys.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofo.modules.sys.dao.UserDao;
import com.ofo.modules.sys.entity.User;
import com.ofo.modules.sys.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDao userDao;
	@Override
	public User selectByName(String userName) {
		// TODO Auto-generated method stub
		User user = userDao.selectByName(userName);
		return user;
	}
	@Override
	public Set<String> findRoles(String userName) {
		// TODO Auto-generated method stub
		Set<String> roleName = userDao.findRoles(userName);
		return roleName;
	}
	@Override
	public Set<String> findPermissions(String userName) {
		// TODO Auto-generated method stub
		Set<String> permissions = userDao.findPermissions(userName);
		return permissions;
	}
	@Override
	public List<User> findUserByLocation(String userLocation) {
		// TODO Auto-generated method stub
		List<User> userList = userDao.findUserByLocation(userLocation);
		return userList;
	}
	@Override
	public List<User> findByPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<User> userList = userDao.findByPage(params);
		return userList;
	}
	@Override
	public int getPageCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int count = userDao.getPageCount(params);
		return count;
	}
	@Override
	public int findOne(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int i = userDao.findOne(params);
		return i;
	}
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		int result = userDao.insert(user);
		return result;
	}
	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
		int result = userDao.delete(user);
		return result;
	}
	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		User user = userDao.findById(id);
		return user;
	}
	@Override
	public int updateByRoot(Map<String, Object> params) {
		// TODO Auto-generated method stub
		int result = userDao.updateByRoot(params);
		return result;
	}
	
	

}
