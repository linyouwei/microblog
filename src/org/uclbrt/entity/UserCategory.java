package org.uclbrt.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserCategory {
	private int id;
	private UserLogin userInfo;
	private String categoryName;
	private int isDelete;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserLogin getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserLogin userInfo) {
		this.userInfo = userInfo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
