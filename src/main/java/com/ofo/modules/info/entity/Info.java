package com.ofo.modules.info.entity;

public class Info {
	
	private Integer id;
	
	private String ofoCode;	//ofo编码
	
	private String ofoPass;	//ofo密码
	
	private String location;	//ofo位置
	
	private String lng;	//经度
	
	private String lat;	//纬度
	
	private String delFlag;	//删除标志位

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOfoCode() {
		return ofoCode;
	}

	public void setOfoCode(String ofoCode) {
		this.ofoCode = ofoCode;
	}

	public String getOfoPass() {
		return ofoPass;
	}

	public void setOfoPass(String ofoPass) {
		this.ofoPass = ofoPass;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	

}
