package org.uclbrt.dao;

import org.uclbrt.entity.UserLogin;

public interface UserLoginMapper {
	void save(UserLogin user);
	UserLogin findByName(String username);
}
