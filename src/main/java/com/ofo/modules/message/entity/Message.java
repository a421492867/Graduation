package com.ofo.modules.message.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Message {
	
	private Integer id;
	
	private String createBy;
	
	private Date createDate;
	
	private Integer messageType;
	
	private String messageTitle;
	
	private String messageContent;
	
	private String delFlag;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}
	
	

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	private String convertData;

	public String getConvertData() {
		return convertData;
	}

	public void setConvertData(String convertData) {
		this.convertData = convertData;
	}
	
	
	
	

}
