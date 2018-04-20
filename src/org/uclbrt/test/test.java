package org.uclbrt.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.uclbrt.dao.DailyMapper;
import org.uclbrt.entity.Daily;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String conf = "sqlMapConfig.xml";
		Reader reader;
		System.out.println(123);
		try {
			reader = Resources.getResourceAsReader(conf);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
			SqlSession session = sqlSessionFactory.openSession();
			DailyMapper mapper = session.getMapper(DailyMapper.class);
			List<Map> list = mapper.findUserCategoryByCategoryName("计算机",1);
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i));
			}
			System.out.println(list.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
