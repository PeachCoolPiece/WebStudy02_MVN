package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.Pagination;
import kr.or.ddit.vo.ProdVO;

public class ProdDAOImpl implements ProdDAO{
	
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertProd(ProdVO prod) {
		try(
			    SqlSession sqlSession =  	sqlSessionFactory.openSession(true);
				){
		ProdDAO mapperProxy = sqlSession.getMapper(ProdDAO.class);
		
		return mapperProxy.insertProd(prod);
		}
	}

	@Override
	public List<ProdVO> selectProdList(Pagination<ProdVO> pagination) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
			){
		
			ProdDAO mapperProxy =  sqlSession.getMapper(ProdDAO.class);
			return mapperProxy.selectProdList(pagination);
		}
	}

	@Override
	public ProdVO selectProd(String prodId) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
			){
		
			ProdDAO mapperProxy =  sqlSession.getMapper(ProdDAO.class);
			return mapperProxy.selectProd(prodId);
		}
	}

	@Override
	public int updateProd(ProdVO prod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectTotalRecord(Pagination<ProdVO> pagination) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
			ProdDAO mapperProxy = sqlSession.getMapper(ProdDAO.class);
				return mapperProxy.selectTotalRecord(pagination);
			}
	}

}
