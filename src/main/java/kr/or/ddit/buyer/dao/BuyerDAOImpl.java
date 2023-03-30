package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.Pagination;

public class BuyerDAOImpl implements BuyerDAO {
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertBuyer(BuyerVO buyer) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);	
		){
			BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
			return mapper.insertBuyer(buyer);
		}
	}
	
	@Override
	public int selectTotalRecord(Pagination<BuyerVO> pagination) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
			return mapper.selectTotalRecord(pagination);
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList(Pagination<BuyerVO> pagination) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
			return mapper.selectBuyerList(pagination);
		}
	}

	@Override
	public BuyerVO selectBuyer(String buyerId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
			return mapper.selectBuyer(buyerId);
		}		
	}

	@Override
	public int updateBuyer(BuyerVO buyer) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);	
		){
			BuyerDAO mapper = sqlSession.getMapper(BuyerDAO.class);
			return mapper.updateBuyer(buyer);
		}
	}

}
