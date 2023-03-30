package kr.or.ddit.mybatis;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

public class CustomSqlSessionFactoryBuilderTest {


	@Test
	public void testGetSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
		assertNotNull(sqlSessionFactory);
		
	}

}
