package kr.or.ddit.schema.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.TableSchemaVO;

public class TableSchemaDAOImpl implements TableSchemaDAO {
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<TableSchemaVO> selectTableSchemaList() {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			TableSchemaDAO mapperProxy = sqlSession.getMapper(TableSchemaDAO.class);
			return mapperProxy.selectTableSchemaList();					
		}
	}

}









