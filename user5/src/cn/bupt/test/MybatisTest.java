package cn.bupt.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.bupt.pojo.User;

public class MybatisTest {

	@Test
	public void run() throws Exception{
		//加载mybatis的核心配置文件
		String resource="mybatis/sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//调用sqlSession中相应的方法
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
	}
}
