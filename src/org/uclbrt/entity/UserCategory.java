package org.uclbrt.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserCategory {
	private int id;
	private int  userId;
	private String categoryName;
	private int isDelete;
	private List<Daily> dailyList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public List<Daily> getDailyList() {
		return dailyList;
	}
	public void setDailyList(List<Daily> dailyList) {
		this.dailyList = dailyList;
	}
	

	
	
}
