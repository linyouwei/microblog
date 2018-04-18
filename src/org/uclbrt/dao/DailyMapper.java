package org.uclbrt.dao;
import java.util.List;
import java.util.Map;

import org.uclbrt.entity.Daily;

public interface DailyMapper {
	List<Daily> getDailyListByUserId(int userId);
	Daily getDailyByUserId(int dailyId);
	List<Daily> findAllDaily();
	List<Daily> findRecentDaily();
	List<Daily> findUserRecentDaily(int userId);
	List<Map> getUserArchivesDate(int userId);
	List<Map> getUserCategoryList(int userId);
	List<Map> getCategoryList();
	
}
