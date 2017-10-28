package com.ofo.modules.info.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ofo.base.util.Page;
import com.ofo.modules.info.entity.Info;
import com.ofo.modules.info.entity.Status;
import com.ofo.modules.info.service.InfoService;
import com.ofo.modules.info.service.StatusService;

@Controller
@RequestMapping(value="info")
public class InfoController {
	
	@Autowired
	private InfoService infoService;
	
	@Autowired
	private StatusService statusService;
	
	@RequestMapping(params="init")
	public String get(){
		return "modules/info/ofoInfo";
	}
	
	/**
	 * 获取所有数据
	 * @param rows
	 * @param page
	 * @return
	 */
	@RequestMapping(value="getData")
	@ResponseBody
	public String getData(int rows, int page){
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (page-1)*rows);
		params.put("pageSize", rows);
		
		int count = 0;
		
		Page<Info> resultPage = new Page<Info>();
		
		count = infoService.getPageCount(params);
		
		List<Info> infoList = infoService.findByPage(params);
		
		resultPage.setList(infoList);
		resultPage.setCount(count);
		resultPage.setPageNo(page);
		resultPage.setPageSize(rows);
		resultPage.setPageType(Page.PAGE_TYPE_JQGRID);
		
		return resultPage.toString();
		
	}
	
	/**
	 * 查询
	 * @param rows
	 * @param page
	 * @param location
	 * @return
	 */
	@RequestMapping(value="search")
	@ResponseBody
	public String search(int rows, int page, String location){
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (page-1)*rows);
		params.put("pageSize", rows);
		params.put("location", location);
		int count;
		Page<Info> resultPage = new Page<Info>();
		count = infoService.getCountWithCondition(params);
		List<Info> infoList = infoService.findPageByCondition(params);
		resultPage.setList(infoList);
		resultPage.setCount(count);
		resultPage.setPageNo(page);
		resultPage.setPageSize(rows);
		resultPage.setPageType(Page.PAGE_TYPE_JQGRID);
		
		return resultPage.toString();
		
	}
	
	/**
	 * 获取增加页面
	 * @return
	 */
	@RequestMapping(value="getAddModal")
	public String getAddModal(){
		return "modules/info/ofoInfo_add";
		
	}
	
	@RequestMapping(value="validate")
	@ResponseBody
	public Map<String, Object> validate(String ofoCode){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ofoCode", ofoCode);
		int i = infoService.findOne(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", i);
		return result;
	}
	
	/**
	 * 新增
	 * @return
	 */
	@RequestMapping(value="addInfo")
	@ResponseBody
	public boolean addInfo(WebRequest webRequest){
		Info info = new Info();
		info.setOfoCode(webRequest.getParameter("ofoCode"));
		info.setOfoPass(webRequest.getParameter("ofoPass"));
		info.setLocation(webRequest.getParameter("location"));
		info.setLng(webRequest.getParameter("lng"));
		info.setLat(webRequest.getParameter("lat"));
		
		int result = infoService.insert(info);
		
		/**
		 * 加入车辆时同时更新status表，默认加入的车辆状态为正常
		 */
		Status status = new Status();
		status.setOfoCode(webRequest.getParameter("ofoCode"));
		status.setOfoStatus("1");
		statusService.insert(status);
		
		
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="getEditModal")
	public ModelAndView getEditModal(String id){
		ModelAndView view = new ModelAndView("modules/info/ofoInfo_edit");
		Info info = infoService.findById(id);
		view.addObject("info", info);
		return view;
	}
	
	/**
	 * 修改
	 * @param webRequest
	 * @param id
	 * @return
	 */
	@RequestMapping(value="editInfo")
	@ResponseBody
	public boolean editInfo(WebRequest webRequest, int id){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("ofoCode", webRequest.getParameter("ofoCode"));
		params.put("ofoPass",webRequest.getParameter("ofoPass"));
		params.put("location",webRequest.getParameter("location"));
		params.put("lng",webRequest.getParameter("lng"));
		params.put("lat",webRequest.getParameter("lat"));
		
		int i = infoService.update(params);
		if(i > 0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除
	 * @param delRowIds
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public boolean delete(int delRowIds){
		Info info = new Info();
		info.setId(delRowIds);
		
		/**
		 * 删除一个单位同时也要在status表中删除
		 */
		String id = String.valueOf(delRowIds);
		Info infoForCode = infoService.findById(id);
		String ofoCode = infoForCode.getOfoCode();
		Status status = new Status();
		status.setOfoCode(ofoCode);
		statusService.delete(status);
		
		int i = infoService.delete(info);
		
		
		
		if(i > 0){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value="getLocation")
	public ModelAndView getLocation(String id){
		
		ModelAndView view = new ModelAndView("modules/info/ofoInfo_showLoc");
		
		Info info = infoService.findLocation(id);
		
		view.addObject("info", info);
		return view;
	}
	
	
}
