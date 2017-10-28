package com.ofo.modules.info.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ofo.base.util.Page;
import com.ofo.modules.info.entity.Info;
import com.ofo.modules.info.entity.Status;
import com.ofo.modules.info.service.StatusService;

@Controller
@RequestMapping(value="status")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	@RequestMapping(params="init")
	public String get(){
		return "modules/info/ofoStatus";
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
		
		Page<Status> resultPage = new Page<Status>();
		
		count = statusService.getPageCount(params);
		
		List<Status> statusList = statusService.findByPage(params);
		
		resultPage.setList(statusList);
		resultPage.setCount(count);
		resultPage.setPageNo(page);
		resultPage.setPageSize(rows);
		resultPage.setPageType(Page.PAGE_TYPE_JQGRID);
		
		return resultPage.toString();
		
	}
	
	@RequestMapping(value="search")
	@ResponseBody
	public String search(int rows, int page, String ofoStatus){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (page-1)*rows);
		params.put("pageSize", rows);
		params.put("ofoStatus", ofoStatus);
		int count;
		Page<Status> resultPage = new Page<Status>();
		count = statusService.getCountWithCondition(params);
		List<Status> statusList = statusService.findPageByCondition(params);
		resultPage.setList(statusList);
		resultPage.setCount(count);
		resultPage.setPageNo(page);
		resultPage.setPageSize(rows);
		resultPage.setPageType(Page.PAGE_TYPE_JQGRID);
		
		return resultPage.toString();
	}

}
