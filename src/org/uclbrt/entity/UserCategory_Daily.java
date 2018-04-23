package org.uclbrt.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserCategory_Daily {
	private int id;
	private int dailyId;
	private int userCategoryId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDailyId() {
		return dailyId;
	}
	public void setDailyId(int dailyId) {
		this.dailyId = dailyId;
	}
	public int getUserCategoryId() {
		return userCategoryId;
	}
	public void setUserCategoryId(int userCategoryId) {
		this.userCategoryId = userCategoryId;
	}

	
}
