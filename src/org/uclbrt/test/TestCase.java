package org.uclbrt.test;



import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.uclbrt.dao.CommentMapper;
import org.uclbrt.dao.DailyMapper;
import org.uclbrt.dao.UserCategoryMapper;
import org.uclbrt.dao.UserDetailMapper;
import org.uclbrt.dao.UserLoginMapper;
import org.uclbrt.entity.Comment;
import org.uclbrt.entity.Daily;
import org.uclbrt.entity.UserCategory;
import org.uclbrt.entity.UserDetail;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.LoginService;

public class TestCase {

//	@Test
//	public void testSave(){
//		String conf = "applicationContext.xml";
//		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
//		UserLoginMapper mapper = ac.getBean("UserLoginMapper",UserLoginMapper.class);
//		UserLogin user = new UserLogin();
//		user.setId(123);
//		user.setUsername("gg");
//		user.setPassword("ggggg");
//		user.setCreate_time(new Date());
//		user.setRole_id(3);
//		mapper.save(user);
//	}
	/*@Test
	public void testGET(){
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		DailyMapper mapper = ac.getBean("DailyMapper",DailyMapper.class);
		System.out.println(mapper);
		
	}*/
	
//	public void testAssociation() throws IOException{ 
//		//配置文件的名称  
//        String resource = "ssm/web.xml";  
//        //通过Mybatis包中的Resources对象很轻松的获取到配置文件  
//        Reader reader = Resources.getResourceAsReader(resource);  
//        //通过SqlSessionFactoryBuilder创建  
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//        //获得session实例  
//        SqlSession session =sqlSessionFactory.openSession();   
//	}
//	@Test
//	public void testDemo() {
//		List<Map> list = new ArrayList<Map>();
//		Map<Integer,String> map = new HashMap<Integer,String>();
//		map.put(1,"123");
//		list.add(map);
//		System.out.println(list);
//		
//	}
//	@Test
//	public void testDao() {
//		String conf = "sqlMapConfig.xml";
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader(conf);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//			SqlSession session = sqlSessionFactory.openSession();
//			UserDetailMapper mapper = session.getMapper(UserDetailMapper.class);
//			UserDetail list = mapper.findDetailByUserId(1);
//			System.out.println(list.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//	}
//	@Test
//	public void testDao1() {
//		String conf = "sqlMapConfig.xml";
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader(conf);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//			SqlSession session = sqlSessionFactory.openSession();
//			DailyMapper mapper = session.getMapper(DailyMapper.class);
//			List<Daily> list = mapper.getDailyListByUserId(1);
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i).toString());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//	}
//	@Test
//	public void testDao() {
//		String conf = "sqlMapConfig.xml";
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader(conf);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//			SqlSession session = sqlSessionFactory.openSession();
//			DailyMapper mapper = session.getMapper(DailyMapper.class);
//			List<Map> list = mapper.getUserCategoryList(1);
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i).get("id"));
//			}
//			System.out.println(list.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//	}
//	
	
//	@Test
//	public void testDemo() {
//		String conf = "sqlMapConfig.xml";
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader(conf);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//			SqlSession session = sqlSessionFactory.openSession();
//			DailyMapper mapper = session.getMapper(DailyMapper.class);
//			UserCategory userCategory = new UserCategory();
//			UserLogin userLogin = new UserLogin();
//			userLogin.setId(5);
//			userCategory.setCategoryName("3333");
//			userCategory.setUserInfo(userLogin);
//			userCategory.setIsDelete(1);
//			int a = mapper.addUserCategory(userCategory);
//			session.commit();
//			System.out.println(a);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//	}
//	@Test
//	public void testDemo() {
//		String conf = "sqlMapConfig.xml";
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader(conf);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//			SqlSession session = sqlSessionFactory.openSession();
//			UserCategoryMapper mapper = session.getMapper(UserCategoryMapper.class);
//			UserCategory userCategory = new UserCategory();
//		
////			List<UserCategory> a = mapper.getUserCategory(1);
////			for(int i=0;i<a.size();i++){
////				List<Daily> list = a.get(i).getDailyList();
////				for(int j=0;j<list.size();j++){
////					System.out.println(list.get(j).getBody());	
////				}
////				
////			}
////			List<Map> list = mapper.findUserCategoryByCategoryName("it", 1);
////			System.out.println(list);
////			userCategory.setCategoryName("www");
////			userCategory.setUserId(3);
////			userCategory.setIsDelete(0);
////			int a = mapper.addUserCategory(userCategory);
////			System.out.println(a);
////			session.commit();
//			System.out.println(userCategory.getId());
//			Date dd = new Date();
//			System.out.println(dd);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//	}
	@Test
	public void testDemo() {
		String conf = "sqlMapConfig.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
			SqlSession session = sqlSessionFactory.openSession();
			DailyMapper mapper = session.getMapper(DailyMapper.class);
			Daily daily = new Daily();
			daily.setBody("3333");
			daily.setCategoryId(Integer.parseInt("1"));
			daily.setClick(0);
			Date createdTime = new Date(); 
			daily.setCreatedTime(createdTime);
			daily.setModifiedTime(createdTime);
			daily.setTitle("34233423");
			UserLogin userInfo = new UserLogin();
			userInfo.setId(1);
			daily.setUserInfo(userInfo);
			mapper.addDaily(daily);
			session.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}



	
	

}
