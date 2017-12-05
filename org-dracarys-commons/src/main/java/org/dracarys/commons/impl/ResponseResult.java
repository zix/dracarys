package org.dracarys.commons.impl;

public class ResponseResult {
	private Integer status = 1;
	private Object message;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	
}
