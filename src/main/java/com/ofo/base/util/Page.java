package com.ofo.base.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Page<T>
 * @author lord.y
 *
 * @param <T>
 */
public class Page<T> {
	
	private int pageNo = 1;	//当前页码
	
	private int pageSize = 10;	//页面大小
	
	private long count;	//总记录数
	
	private String pageType = "";
	
	private List<T> list = new ArrayList<T>();
	
	private String formatType = "yyyy-MM-dd HH:mm:ss";
	
	public static final String PAGE_TYPE_JQGRID= "jqgrid";
	
	public Page(){
		
	}

	/**
	 * 构造方法
	 * @param pageNo
	 * @param pageSize
	 * @param count
	 * @param list
	 */
	public Page(int pageNo, int pageSize, long count, List<T> list){
		this.setCount(count);
		this.setPageNo(pageNo);
		this.pageSize = pageSize;
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize <= 0 ? 10 : pageSize;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
		/**
		 * 页面大小大于总数，pageNo为1
		 */
		if (pageSize >= count){
			pageNo = 1;
		}
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		if (PAGE_TYPE_JQGRID.equals(pageType)) {
			JSONObject jsonObject = new JSONObject();
			int totalPages;
	        if (count % pageSize == 0) {
	            totalPages = (int) (count / pageSize);
	        } else {
	            totalPages = (int) ((count / pageSize) + 1);
	        }
			jsonObject.put("rows", list);
			jsonObject.put("total", totalPages);
			jsonObject.put("page", pageNo);
			jsonObject.put("records", count);
			return JSON.toJSONStringWithDateFormat(jsonObject, formatType);
		}
		return null;
	}
	
	
	
	
	
	

}
