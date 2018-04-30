package org.uclbrt.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDetail implements Serializable {

	private int id;
	private UserLogin userInfo;
	private String img_path;
	private int gender ;
	private Date birthday;
	private Province province;
	private City city;
	private int marriage;
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
	
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String imgPath) {
		img_path = imgPath;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public int getMarriage() {
		return marriage;
	}
	public void setMarriage(int marriage) {
		this.marriage = marriage;
	}
	@Override
	public String toString() {
		return "UserDetail [birthday=" + birthday + ", city=" + city.toString()
				+ ", gender=" + gender + ", id=" + id + ", img_path="
				+ img_path + ", marriage=" + marriage + ", province="
				+ province.toString() + ", userInfo=" + userInfo.toString() + "]";
	}
	
	
	
	

	
}
