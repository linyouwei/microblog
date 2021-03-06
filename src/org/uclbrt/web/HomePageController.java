package org.uclbrt.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.uclbrt.entity.City;
import org.uclbrt.entity.Comment;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.Province;
import org.uclbrt.entity.UserCategory;
import org.uclbrt.entity.UserDetail;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.HomePageService;
import org.uclbrt.util.EmptyUtil;
import org.uclbrt.util.SystemConstant;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;  
import org.apache.commons.lang.math.RandomUtils; 

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
			map.put("userDetail",userDetail);	
			return "../jsp/topic/setting";	
		}
		return "../jsp/topic/setting";	
	}
	@RequestMapping(value ="/settingBasic.form", method = RequestMethod.POST)
	@ResponseBody
	public Result addUserDetail(@RequestBody  Map<String, Object>  param, ModelMap map,HttpSession session) {

		String nickname = (String) param.get("nickname");
		String birth_time = (String) param.get("birth_time");
		String province_code = (String) param.get("province");
		String city_code = (String) param.get("city");
		String marriage = (String) param.get("marriage");
		String gender = (String) param.get("gender");
		UserLogin user = (UserLogin) session.getAttribute("user");
		System.out.println(user.getId());
		Map<String,Object> hmap = new HashMap(); 
		if(!EmptyUtil.isNullOrEmpty(user)){
			//获取userDetail
			UserDetail userDetail = new UserDetail();
			UserLogin userLogin = new UserLogin();
			Province province = new Province();
			City city = new City();
			
			userLogin.setUserName(nickname);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(birth_time!=null){
				try {
					userDetail.setBirthday(sdf.parse(birth_time));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
			if(province_code!=null){
				province.setCode(Integer.parseInt(province_code));
			}
			if(city_code!=null){
				city.setCode(Integer.parseInt(city_code));
			}
			userLogin.setId(user.getId());
			
			
			userDetail.setProvince(province);
			userDetail.setCity(city);
			userDetail.setGender(Integer.parseInt(gender));
			userDetail.setMarriage(Integer.parseInt(marriage));
			userDetail.setUserInfo(userLogin);
			System.out.println("5555"+userDetail.toString());
			
			int i = homePageService.updateUserDetail(userDetail);
			if(i>0){
				hmap.put("status",200);
			}
			return new Result(hmap);	
		}
		return new Result(hmap);	
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
	//@RequestBody String title,@RequestBody String content,@RequestBody List<String> tagsArr,@RequestBody List<UserCategory> userCategoryList,@RequestBody List<String> existUserCategoryList,@RequestBody String category
	//@RequestBody  Map<String, Object>  param,HttpSession session
	@RequestMapping(value ="/publish.form", method = RequestMethod.POST)
	@ResponseBody
	public Result addDaily(@RequestBody  Map<String, Object>  param,HttpSession session) {
		String title = (String) param.get("title");
		String content = (String) param.get("content");
		List<String> tagsArr = (List<String>) param.get("tagsArr");
		List<String> userCategoryArr = (List<String>) param.get("userCategoryArr");
		List<String> existUserCategoryArr = (List<String>) param.get("existUserCategoryArr");
		String category = (String) param.get("category");
		List<String> list = (List<String>) param.get("userCategoryArr");
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(!EmptyUtil.isNullOrEmpty(user)){
			//插入daily
			Daily daily = new Daily();
			daily.setBody(content);
			daily.setCategoryId(Integer.parseInt(category));
			daily.setClick(0);
			Date createdTime = new Date(); 
			daily.setCreatedTime(createdTime);
			daily.setModifiedTime(createdTime);
			daily.setTitle(title);
			UserLogin userInfo = new UserLogin();
			userInfo.setId(user.getId());
			daily.setUserInfo(userInfo);
			homePageService.addDaily(daily);
			for(int i=0;i<tagsArr.size();i++){
				//插入文章标签
				System.out.println("daily:"+daily.toString());
				System.out.println("tagsArr:"+tagsArr.get(i));
				homePageService.addDailyTag(user.getId(),daily.getId(),tagsArr.get(i));
			}
			
			//获取新增的个人分类，若存在，则不存储
			for(int i=0;i<userCategoryArr.size();i++){
				System.out.println("userCategoryArr:"+userCategoryArr.get(i));
				List<Map> userCategory  = homePageService.findUserCategoryByCategoryName(userCategoryArr.get(i), user.getId());
				if(userCategory!=null&&userCategory.size()!=0){
					//不存储
				}else{
					//存储该分类
					UserCategory new_category = new UserCategory(); 
					new_category.setCategoryName(userCategoryArr.get(i));
					new_category.setIsDelete(0);
					new_category.setUserId(user.getId());
					UserLogin userLogin = new UserLogin();
					int a = homePageService.addUserCategory(new_category);
					if(a==1){
						System.out.println("插入成功");
						//插入`user_daily_details`
						homePageService.addUserDailyDetail(daily.getId(),new_category.getId());
					}else{
						System.out.println("插入失败");
					}
				}
			}
			
			//获取已存在的个人分类,并存储user_daily_details表中
			for(int i=0;i<existUserCategoryArr.size();i++){
				homePageService.addUserDailyDetail(daily.getId(),Integer.parseInt(existUserCategoryArr.get(i)));	
			}		
		}
		Map<String,Object> map = new HashMap(); 
		map.put("status", 200);
		return new Result(map);
	}
	@RequestMapping(value ="/publishSuccess.form", method = RequestMethod.GET)
	public String publishSuccess(ModelMap map,HttpSession session) {
		return "../jsp/topic/publish-success";	
	}
	
//	@RequestMapping(value ="/addPhoto.form", method = RequestMethod.POST)
//	public String addPet(MultipartFile photo,HttpServletRequest req) throws IllegalStateException, IOException {
//		if (!photo.isEmpty()) {
//				String path=req.getServletContext().getRealPath("/");
//				String img_path ="images/";
//	            String originalFileName = photo.getOriginalFilename();
//	            // 新的图片名称
//	            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
//	            // 新的图片
//	            File newFile = new File(path +img_path+newFileName);
//	            System.out.println(path +img_path+newFileName);
//	            // 将内存中的数据写入磁盘
//	            photo.transferTo(newFile);
//	        }
//			return "123";
//	}
	@RequestMapping(value ="/addPhoto.form", method = RequestMethod.POST)
	@ResponseBody 
	public Result addPhoto(@RequestParam("photo") MultipartFile photo,HttpServletRequest req,HttpSession session) throws IllegalStateException, IOException {
		Map<String, Object> map=new HashMap();  
		UserLogin user = (UserLogin) session.getAttribute("user");
		if(user!=null){
			String relPathOfSavedDir = "/Uploads/images/";
			 try {    
		           File savedDir = prepareSavedDir(req, relPathOfSavedDir);    
		           String savedFileName=getSavedFileName(photo.getOriginalFilename());    
		           photo.transferTo(new File(savedDir,savedFileName));    
		           String imgUrl=relPathOfSavedDir+savedFileName;  
		           System.out.println("imgUrl:"+imgUrl);
		           
		           map.put("imgUrl", imgUrl);  
		           
		           	//存储该图片路径
		            UserDetail userDetail = new UserDetail();
					UserLogin userLogin = new UserLogin();
					Province province = new Province();
					City city = new City();
					userLogin.setId(user.getId());
					userDetail.setImg_path(imgUrl);		
					userDetail.setUserInfo(userLogin);
					int i = homePageService.updateUserDetail(userDetail);
					if(i>0){
						map.put("status",200);
					}
					return new Result(map);	
		       } catch (Exception e) {    
		           return null;    
		       }    
			
		}
		return  new Result(map);    
		
	}
	 private File prepareSavedDir(HttpServletRequest request,String relativePath) throws Exception{    
	       File dir=new File(request.getSession().getServletContext().getRealPath(relativePath));   
	       System.out.println("dir:"+request.getSession().getServletContext().getRealPath(relativePath));
	       if(!dir.exists()){    
	           if(!dir.mkdirs()){    
	               throw new Exception("创建保存目录失败");    
	           }    
	       }    
	       return dir;    
	   }    
	       
	   private String getSavedFileName(String origFileName){    
	       return RandomStringUtils.randomNumeric(16)+"."+FilenameUtils.getExtension(origFileName);    
	   }   

}
