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
		//����mybatis�ĺ��������ļ�
		String resource="mybatis/sqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		
		//����SqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//����sqlSession����Ӧ�ķ���
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
	}
}
