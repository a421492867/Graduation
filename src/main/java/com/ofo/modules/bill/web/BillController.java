package com.ofo.modules.bill.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ofo.base.util.Page;
import com.ofo.modules.bill.entity.Bill;
import com.ofo.modules.bill.service.BillService;
import com.ofo.modules.info.entity.Info;

@Controller
@RequestMapping(value="bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(params="init")
	public String get(){
		return "modules/bill/bill";
	}
	
	
	@RequestMapping(value="getData")
	@ResponseBody
	public String getData(int rows, int page){
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (page-1)*rows);
		params.put("pageSize", rows);
		
		int count = 0;
		
		Page<Bill> resultPage = new Page<Bill>();
		
		count = billService.getPageCount(params);
		
		List<Bill> billList = billService.findByPage(params);
		
		resultPage.setList(billList);
		resultPage.setCount(count);
		resultPage.setPageNo(page);
		resultPage.setPageSize(rows);
		resultPage.setPageType(Page.PAGE_TYPE_JQGRID);
		
		return resultPage.toString();
		
	}
	
	
	

}
