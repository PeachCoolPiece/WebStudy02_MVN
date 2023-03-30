package kr.or.ddit.schema.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ColumnSchemaVO;

public class ColumnSchemaDAOImpl implements ColumnSchemaDAO {
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
//	persistence framework (sql mapper, data mapper, orm framework) : iBatis, myBaits, JPA, Hibernate...
	@Override
	public List<ColumnSchemaVO> selectColumnSchemaListByTableName(String tableName) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			ColumnSchemaDAO mapperProxy = sqlSession.getMapper(ColumnSchemaDAO.class);
			return mapperProxy.selectColumnSchemaListByTableName(tableName);
		}
	}

}









