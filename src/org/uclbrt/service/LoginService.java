package org.uclbrt.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.uclbrt.dao.UserLoginMapper;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.util.Md5Util;
import org.uclbrt.util.SystemConstant;

@Service
public class LoginService implements SystemConstant {
	@Resource
	private UserLoginMapper userLoginMapper;

	public Map<String, Object> addUser(UserLogin user) {
		if (user == null) {
			throw new RuntimeException("参数为空");
		}
		// 判断用户名是否存在
		UserLogin user_name = userLoginMapper.findByName(user.getUserName());
		Map<String, Object> map = new HashMap<String, Object>();
		if (user_name == null) {
			// 数据库没有，插入该数据
			user.setUserName(user.getUserName());
			user.setPassword(Md5Util.md5(user.getPassword()));
			Date d = new Date();
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			user.setCreatedTime(d);
			user.setRoleId('3');
			userLoginMapper.save(user);
			map.put("pass", true);
		} else {
			map.put("pass", false);
		}
		//
		return map;
	}

	public Map<String, Object> checkLogin(String userName, String password) {
		if (userName == null & password == null)
			throw new RuntimeException("用户名或密码不能为空");
		
		Map<String, Object> map = new HashMap<String, Object>();
		UserLogin user = userLoginMapper.findByName(userName);
		if (user == null) {
			map.put("status", NAME_ERROR);
		} else {
			if (user.getPassword().equals(Md5Util.md5(password))) {
				map.put("status", SUCCESS);
				map.put("user", user);
			} else {
				map.put("status", PASSWORD_ERROR);
			}
		}
		return map;
	}
}
