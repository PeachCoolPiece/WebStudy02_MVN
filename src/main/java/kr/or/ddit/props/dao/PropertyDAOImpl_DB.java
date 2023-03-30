package kr.or.ddit.props.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.props.vo.PropertyVO;

public class PropertyDAOImpl_DB implements PropertyDAO{

	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<PropertyVO> selectProperties(String propertyName) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			PropertyDAO mapperProxy = sqlSession.getMapper(PropertyDAO.class);
			return mapperProxy.selectProperties(propertyName);				
		}
	}

	@Override
	public int insertProperty(PropertyVO propertyVO) {
		throw new RuntimeException("뷰를 대상으로 한 insert 불가능");
	}

	@Override
	public int updateProperty(PropertyVO prop) {
		throw new RuntimeException("뷰를 대상으로 한 update 불가능");
	}

	@Override
	public int deleteProperty(PropertyVO prop) {
		throw new RuntimeException("뷰를 대상으로 한 delete 불가능");
	}

}
