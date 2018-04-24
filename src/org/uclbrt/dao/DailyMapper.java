package org.uclbrt.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.UserCategory;

public interface DailyMapper {
	List<Daily> getDailyListByUserId(int userId);
	Daily getDailyByUserId(int dailyId);
	List<Daily> findAllDaily();
	List<Daily> findRecentDaily();
	List<Daily> findUserRecentDaily(int userId);
	List<Map> getUserArchivesDate(int userId);
	List<Map> getUserCategoryList(int userId);
	List<Map> getCategoryList();
	List<Map> findUserCategoryByCategoryName(@Param("category_name") String category_name,
			@Param("user_login_id") int user_login_id	
	);
	int addUserCategory(UserCategory userCategory);
	int addUserDailyDetail(@Param("daily_id") int daily_id ,
			@Param("user_category_id") int user_category_id
			);
	int addDaily(Daily daily);
	int addDailyTag(@Param("userId")int userId,
			@Param("dailyId")int dailyId,
			@Param("name") String name);
	
}
