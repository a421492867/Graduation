package com.ofo.modules.sys.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonBackReference;


public class Menu {
	
	private String id;
	
	//父级Id
	private String parentId;
	
	//菜单名称
	private String name;
	
	//拍讯
	private Integer sort;
	
	//URL
	private String href;
	
	//图标
	private String icon;
	
	//权限
	private String roleId;
	
	
	private List<Menu> children;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
	
	
	

	
	
	
	
	
	

}
