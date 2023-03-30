package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.Pagination;

public class MemberDAOImpl implements MemberDAO {
	private SqlSessionFactory sqlSessionFactory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public MemberVO selectMemberForAuth(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMemberForAuth(memId);
		}
	}

	@Override
	public int insertMember(MemberVO member) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
				MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
				int rowcnt = mapperProxy.insertMember(member);
				sqlSession.commit();
				return rowcnt;
			}
	}

	@Override
	public int selectTotalRecord(Pagination<MemberVO> pagination) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectTotalRecord(pagination);
		}
	}
	
	@Override
	public List<MemberVO> selectMemberList(Pagination<MemberVO> pagination) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMemberList(pagination);
		}
	}

	@Override
	public MemberVO selectMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
			return mapperProxy.selectMember(memId);
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession(true);	
			){
				MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
				int rowcnt = mapperProxy.updateMember(member);
				return rowcnt;
			}
	}

	@Override
	public int deleteMember(String memId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession(true);	
		){
			return sqlSession.update("kr.or.ddit.member.dao.MemberDAO.deleteMember", memId);
		}
	}

}










