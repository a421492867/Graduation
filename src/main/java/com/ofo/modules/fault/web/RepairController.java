package com.ofo.modules.fault.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ofo.base.util.Page;
import com.ofo.modules.fault.vo.StatusVO;
import com.ofo.modules.info.service.StatusService;
import com.ofo.modules.sys.entity.User;
import com.ofo.modules.sys.service.UserService;

/**
 * 故障管理
 * ofoStatus为2
 * @author lord.y
 *
 */
@Controller
@RequestMapping(value="repair")
public class RepairController {
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(params="init")
	public String get(){
		return "modules/fault/repair";
	}
	
	
	@RequestMapping(value="getData")
	@ResponseBody
	public String getData(int rows, int page){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (page-1)*rows);
		params.put("pageSize", rows);
		params.put("ofoStatus", "2");
		
		int count = 0;
		Page<StatusVO> resultPage = new Page<StatusVO>();
		count = statusService.getPageCountByStatus(params);
		List<StatusVO> resultList = statusService.findPageByStatus(params);
		resultPage.setList(resultList);
		resultPage.setCount(count);
		resultPage.setPageNo(page);
		resultPage.setPageSize(rows);
		resultPage.setPageType(Page.PAGE_TYPE_JQGRID);
		
		return resultPage.toString();
	}
	
	@RequestMapping(value="search")
	@ResponseBody
	public String search(int rows, int page, String location){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (page-1)*rows);
		params.put("pageSize", rows);
		params.put("ofoStatus", "2");
		params.put("location", location);
		int count = 0;
		Page<StatusVO> resultPage = new Page<StatusVO>();
		count = statusService.getPageCountByStatus(params);
		List<StatusVO> resultList = statusService.findPageByStatus(params);
		resultPage.setList(resultList);
		resultPage.setCount(count);
		resultPage.setPageNo(page);
		resultPage.setPageSize(rows);
		resultPage.setPageType(Page.PAGE_TYPE_JQGRID);
		
		return resultPage.toString();
	}
	
	@RequestMapping(value="getEditModal")
	public ModelAndView getEditModal(int id){
		ModelAndView view = new ModelAndView("modules/fault/repair_edit");
		StatusVO statusVo = statusService.findVoById(id);
		String userLocation = statusVo.getLocation();
		List<User> userList = userService.findUserByLocation(userLocation);
		view.addObject("statusVo", statusVo);
		view.addObject("userList", userList);
		return view;
	}

}
