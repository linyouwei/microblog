package org.uclbrt.test;



import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.uclbrt.dao.UserDetailMapper;
import org.uclbrt.entity.City;
import org.uclbrt.entity.Province;
import org.uclbrt.entity.UserDetail;
import org.uclbrt.entity.UserLogin;

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
//	@Test
//	public void testDemo() {
//		String conf = "sqlMapConfig.xml";
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader(conf);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//			SqlSession session = sqlSessionFactory.openSession();
//			DailyMapper mapper = session.getMapper(DailyMapper.class);
//			Daily daily = new Daily();
//			daily.setBody("3333");
//			daily.setCategoryId(Integer.parseInt("1"));
//			daily.setClick(0);
//			Date createdTime = new Date(); 
//			daily.setCreatedTime(createdTime);
//			daily.setModifiedTime(createdTime);
//			daily.setTitle("34233423");
//			UserLogin userInfo = new UserLogin();
//			userInfo.setId(1);
//			daily.setUserInfo(userInfo);
//			mapper.addDaily(daily);
//			session.commit();
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
//			UserDetailMapper mapper = session.getMapper(UserDetailMapper.class);
//			System.out.println(mapper.findDetailByUserId(1).getProvince().getName());
//
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//	}
//	
//	@Test
//	public void testAddUser() {
//		String conf = "sqlMapConfig.xml";
//		Reader reader;
//		try {
//			reader = Resources.getResourceAsReader(conf);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
//			SqlSession session = sqlSessionFactory.openSession();
//			UserLoginMapper mapper = session.getMapper(UserLoginMapper.class);
//			UserLogin user = new UserLogin();
//			user.setUserName("yyy");
//			user.setPassword(Md5Util.md5("1234"));
//			user.setRoleId(3);
//			Date date = new Date();
//			user.setCreatedTime(date);
//			mapper.save(user);
//			session.commit();
//			//插入userDetail表
//			UserDetail ud = new UserDetail();
//			ud.setUserInfo(user);
//			UserDetailMapper uMapper = session.getMapper(UserDetailMapper.class);
//			uMapper.addUserDetail(ud);
//			session.commit();
//			System.out.println(ud.getId());
//
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		
//	}
	@Test
	public void testUpdate() {
		String conf = "sqlMapConfig.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(conf);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
			SqlSession session = sqlSessionFactory.openSession();
			UserDetailMapper mapper = session.getMapper(UserDetailMapper.class);
			UserLogin user = new UserLogin();
			UserDetail userDetail = new UserDetail();
			Province province = new Province();
			City city = new City();
			user.setId(1);
//			user.setUserName("yyyy");
			//UserDetail [birthday=Tue Apr 10 00:00:00 GMT+08:00 2018, city=City [code=4201, name=null, province=null], 
			//gender=0, id=0, img_path=null, marriage=1, province=org.uclbrt.entity.Province@144dc7b, 
			//userInfo=UserLogin [createdTime=null, id=1, password=null, roleId=0, userName=www]]

//			province.setCode(14);
//			city.setCode(1401);
//			Date date = new Date();
//			userDetail.setBirthday(date);
//			userDetail.setProvince(province);
//			userDetail.setCity(city);
//			userDetail.setGender(0);
//			userDetail.setMarriage(1);
			
			userDetail.setImg_path("/microblog/Uploads/images/6459956910456571.jpg");
			userDetail.setUserInfo(user);
			int i = mapper.updateUserDetail(userDetail);
			session.commit();
			System.out.println(i);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}




	
	

}
