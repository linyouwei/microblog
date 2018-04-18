package org.uclbrt.web;

import java.io.Serializable;

public class Result implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8872846466561402061L;
	private  boolean success = true;
	private String message;
	private Object data;
	public Result(){
		
	}
	public Result(Object data){
		this.data=data;
	}
	public Result(boolean success,String message,Object data){
		this.success=success;
		this.message = message;
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
