package org.uclbrt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.uclbrt.dao.CommentMapper;
import org.uclbrt.dao.DailyMapper;
import org.uclbrt.dao.UserDetailMapper;
import org.uclbrt.entity.Comment;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.UserDetail;
import org.uclbrt.util.SystemConstant;

@Service
public class HomePageService implements SystemConstant {
	@Resource
	private DailyMapper dailyMapper;
	@Resource
	private CommentMapper commentMapper;
	@Resource
	private UserDetailMapper userDetailMapper;

	public List<Daily> getDailyListByUserId(int userId) {
		List<Daily> list=  dailyMapper.getDailyListByUserId(userId);
		return  list;
	}
	public List<Daily> getAllDaily() {
		List<Daily> list=  dailyMapper.findAllDaily();
		return  list;
	}
	public List<Daily> findRecentDaily() {
		List<Daily> list=  dailyMapper.findRecentDaily();
		return  list;
	}
	public List<Daily> findUserRecentDaily(int id ) {
		List<Daily> list=  dailyMapper.findUserRecentDaily(id);
		return  list;
	}
	public List<Map> getUserArchivesDate(int id ) {
		HashMap<String,String> map = new HashMap<String,String>();
		List<Map> list=  dailyMapper.getUserArchivesDate(id);
		return  list;
	}
	public List<Map> getUserCategoryList(int id ) {
		HashMap<String,String> map = new HashMap<String,String>();
		List<Map> list=  dailyMapper.getUserCategoryList(id);
		return  list;
	}
	public List<Map> getCategoryList() {
		HashMap<String,String> map = new HashMap<String,String>();
		List<Map> list=  dailyMapper.getCategoryList();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		return  list;
	}
	public Daily getDailyByUserId(int id) {
		Daily daily= dailyMapper.getDailyByUserId(id);
		return  daily;
	}

	public List<Comment> getCommentByDailyId(int userId) {
		List<Comment> list=  commentMapper.getCommentByDailyId(userId);
		return  list;
	}
	public UserDetail findDetailByUserId(int userId) {
		UserDetail userDetail=  userDetailMapper.findDetailByUserId(userId);
		return  userDetail;
	}
}
