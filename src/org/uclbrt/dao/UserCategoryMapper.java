package org.uclbrt.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.UserCategory;

public interface UserCategoryMapper {
	
	int addUserCategory(UserCategory userCategory);
	List<UserCategory> getUserCategory(int id);
	List<Map> findUserCategoryByCategoryName(@Param("category_name") String category_name,
			@Param("user_login_id") int user_login_id	
	);
	

}
