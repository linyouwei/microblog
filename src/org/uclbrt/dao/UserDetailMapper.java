package org.uclbrt.dao;

import org.uclbrt.entity.UserDetail;
import org.uclbrt.entity.UserLogin;

public interface UserDetailMapper {
	UserDetail findDetailByUserId(int userId);
	int addUserDetail(UserDetail user);
}
