package org.uclbrt.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLogin implements Serializable {

	private static final long serialVersionUID = 1393438783592387512L;
	private int id;
	private String userName;
	private String password;
	private Date createdTime;
	private int roleId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserLogin [createdTime=" + createdTime + ", id=" + id
				+ ", password=" + password + ", roleId=" + roleId
				+ ", userName=" + userName + "]";
	}
	
}
