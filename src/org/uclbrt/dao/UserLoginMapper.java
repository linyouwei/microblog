package org.uclbrt.dao;

import org.uclbrt.entity.UserLogin;

public interface UserLoginMapper {
	int save(UserLogin user);
	UserLogin findByName(String username);
}
