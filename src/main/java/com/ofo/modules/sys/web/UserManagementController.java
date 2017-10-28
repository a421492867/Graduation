package com.ofo.modules.sys.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ofo.base.util.Page;
import com.ofo.modules.sys.entity.Role;
import com.ofo.modules.sys.entity.User;
import com.ofo.modules.sys.service.RoleService;
import com.ofo.modules.sys.service.UserService;

@Controller
@RequestMapping(value="userMgn")
public class UserManagementController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(params="init")
	public ModelAndView get(){
		ModelAndView view = new ModelAndView("modules/sys/userManagement");
		List<Role> roleList = roleService.findRole();
		view.addObject("roleList", roleList);
		return view;
	}
	
	@RequestMapping(value="getData")
	@ResponseBody
	public String getData(int rows, int page){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (page-1)*rows);
		params.put("pageSize", rows);
		
		int count = 0;
		
		Page<User> resultPage = new Page<User>();
		count = userService.getPageCount(params);
		List<User> userList = userService.findByPage(params);
		resultPage.setList(userList);
		resultPage.setCount(count);
		resultPage.setPageNo(page);
		resultPage.setPageSize(rows);
		resultPage.setPageType(Page.PAGE_TYPE_JQGRID);
		
		return resultPage.toString();
	}
	
	@RequestMapping(value="getRoleName")
	@ResponseBody
	public Map<String, Object> getRoleName(){
		List<Role> roleList = roleService.findRole();
		Map<String, Object> roleMap = new HashMap<String, Object>();
		for(int i = 0; i < roleList.size(); i++){
			String roleName = roleList.get(i).getRoleName();
			String roleId = roleList.get(i).getId().toString();
			roleMap.put(roleId, roleName);
		}
		return roleMap;
	}
	
	@RequestMapping(value="search")
	@ResponseBody
	public String search(int rows, int page, String roleId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (page-1)*rows);
		params.put("pageSize", rows);
		params.put("roleId", roleId);
		int count;
		Page<User> resultPage = new Page<User>();
		count = userService.getPageCount(params);
		List<User> userList = userService.findByPage(params);
		resultPage.setList(userList);
		resultPage.setCount(count);
		resultPage.setPageNo(page);
		resultPage.setPageSize(rows);
		resultPage.setPageType(Page.PAGE_TYPE_JQGRID);
		
		return resultPage.toString();
	}
	
	@RequestMapping(value="getAddModal")
	public ModelAndView getAddModal(){
		ModelAndView view = new ModelAndView("modules/sys/userManagement_add");
		List<Role> roleList = roleService.findRole();
		view.addObject("roleList", roleList);
		return view;
	}
	
	@RequestMapping(value="validate")
	@ResponseBody
	public Map<String, Object> validate(String userName){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		int i = userService.findOne(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", i);
		return result;
	}
	
	@RequestMapping(value="addUser")
	@ResponseBody
	public boolean addUser(WebRequest webRequest){
		User user = new User();
		user.setUserName(webRequest.getParameter("userName"));
		user.setNickName(webRequest.getParameter("nickName"));
		user.setPassword(webRequest.getParameter("password"));
		user.setRoleId(webRequest.getParameter("roleId"));
		user.setUserLocation(webRequest.getParameter("userLocation"));
		int result = userService.insert(user);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public boolean delete(int delRowIds){
		User user = new User();
		user.setId(delRowIds);
		int result = userService.delete(user);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="getEditModal")
	public ModelAndView getEditModal(String id){
		ModelAndView view = new ModelAndView("modules/sys/userManagement_edit");
		User user = userService.findById(id);
		List<Role> roleList = roleService.findRole();
		view.addObject("user", user);
		view.addObject("roleList", roleList);
		return view;
	}
	
	@RequestMapping(value="editUserByRoot")
	@ResponseBody
	public boolean editUserByRoot(WebRequest webRequest, int id){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("nickName", webRequest.getParameter("nickName"));
		params.put("roleId", webRequest.getParameter("roleId"));
		params.put("userLocation", webRequest.getParameter("userLocation"));
		int i = userService.updateByRoot(params);
		if(i > 0){
			return true;
		}else{
			return false;
		}
	}

}
