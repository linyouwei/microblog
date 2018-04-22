package org.uclbrt.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.uclbrt.entity.Comment;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.UserCategory;
import org.uclbrt.entity.UserDetail;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.HomePageService;
import org.uclbrt.util.EmptyUtil;
import org.uclbrt.util.SystemConstant;

/**
 * 用户登录,注册等功能
 *
 * @author YouWei Lin
 * @since 1.0.0
 */
@Controller
@RequestMapping("/homePage")
public class HomePageController implements SystemConstant {
	@Resource
	private HomePageService homePageService;

	@RequestMapping(value ="/index.form", method = RequestMethod.GET)
	public String index(ModelMap map,HttpSession session) {
		System.out.println(123);
		UserLogin user = (UserLogin) session.getAttribute("user");
		System.out.println(user);
		if(!EmptyUtil.isNullOrEmpty(user)){
			System.out.println(222);
			//查询该用户的博客列表
			List<Daily> dailyList = homePageService.getDailyListByUserId(user.getId());
			//查询该用户的最新博客
			List<Daily> recentDailyList = homePageService.findUserRecentDaily(user.getId());
			//查询该用户的归档
			List<Map> archivesList = homePageService.getUserArchivesDate(user.getId());
			//查询用户自定义分类列表
			List<Map> userCategoryList = homePageService.getUserCategoryList(user.getId());
	
			
			map.put("dailyList",dailyList);	
			map.put("recentDailyList",recentDailyList);	
			map.put("archivesList",archivesList);	
			map.put("userCategoryList",userCategoryList);	
			return "../jsp/topic/index";	
		}else{
			System.out.println('1');
			//查询所有博客列表
			List<Daily> dailyList = homePageService.getAllDaily();
			//查询最新博客（整个系统的）
			List<Daily> recentDailyList = homePageService.findRecentDaily();
			//查询整个系统的分类
			List<Map> categoryList = homePageService.getCategoryList();
			System.out.println('2');
			map.put("dailyList",dailyList);	
			map.put("recentDailyList",recentDailyList);	
			map.put("categoryList",categoryList);	
			return "../jsp/topic/index";	
		}		
	}
	@RequestMapping(value ="/dailyDetail.form", method = RequestMethod.GET)
	public String daily(int dailyId,ModelMap map,HttpSession session) {
		System.out.println("333"+dailyId);
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(!EmptyUtil.isNullOrEmpty(user)){
			//获取daily
			Daily daily = homePageService.getDailyByUserId(dailyId);
			//获取评论
			List<Comment> commentList = homePageService.getCommentByDailyId(user.getId());
			map.put("daily",daily);	
			map.put("commentList",commentList);	
			return "../jsp/topic/detail";	
		}
		return "../jsp/topic/index";	
	}
	@RequestMapping(value ="/setting.form", method = RequestMethod.GET)
	public String setting(ModelMap map,HttpSession session) {
		//获取用户基本信息
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(!EmptyUtil.isNullOrEmpty(user)){
			//获取userDetail
			UserDetail userDetail = homePageService.findDetailByUserId(user.getId());
			//获取评论
			List<Comment> commentList = homePageService.getCommentByDailyId(user.getId());
			map.put("userDetail",userDetail);	
			map.put("commentList",commentList);	
			return "../jsp/topic/setting";	
		}
		return "../jsp/topic/setting";	
	}
	@RequestMapping(value ="/publishEdit.form", method = RequestMethod.GET)
	public String publishEditIndex(ModelMap map,HttpSession session) {
		//获取用户基本信息
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(!EmptyUtil.isNullOrEmpty(user)){
			//查询博客分类
			List<Map> categoryList = homePageService.getCategoryList();
			
			//查询博客个人分类
			List<Map> existUserCategory = homePageService.getUserCategoryList(user.getId());
			
			map.put("categoryList",categoryList);
			map.put("existUserCategory",existUserCategory);
			return "../jsp/topic/publishEdit";	
		}
		return "../jsp/user/login";	
	}
	@RequestMapping(value ="/publishEdit.form", method = RequestMethod.POST)
	public String addDaily(@RequestBody String title,
			@RequestBody String content,
			@RequestBody List<String> tagsArr,
			@RequestBody List<UserCategory> userCategoryList,
			@RequestBody String existUserCategoryList,
			@RequestBody String category,
			
			ModelMap map,HttpSession session) {
		//获取用户基本信息
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(!EmptyUtil.isNullOrEmpty(user)){
			System.out.println(title);
			System.out.println(content);
			for(int i=0;i<tagsArr.size();i++){
				System.out.println(tagsArr.get(i));
			}
			
			//获取文章标签
			//获取新增的个人分类，若存在，则不存储
			for(int i=0;i<userCategoryList.size();i++){
				List<Map> userCategory  = homePageService.findUserCategoryByCategoryName(userCategoryList.get(i).getCategoryName(), user.getId());
				if(userCategory!=null&&userCategory.size()!=0){
					//不存储
				}else{
					//存储该分类
					UserCategory u_Category = userCategoryList.get(i); 
					UserLogin userLogin = new UserLogin();
					int a = homePageService.addUserCategory(u_Category);
				}
			}
			
			//获取已存在的个人分类
			
			//获取勾选博客分类
			
			List<Map> categoryList = homePageService.getCategoryList();
			
			//查询博客个人分类
			List<Map> existUserCategory = homePageService.getUserCategoryList(user.getId());
			
			map.put("categoryList",categoryList);
			map.put("existUserCategory",existUserCategory);
			return "../jsp/topic/publishEdit";	
		}
		return "../jsp/user/login";	
	}

	
	

}
