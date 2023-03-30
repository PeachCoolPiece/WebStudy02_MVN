package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.Pagination;

public class MemberDAOImplTest {
	
	MemberDAO dao = new MemberDAOImpl();
	
	@Test
	public void testPuselectMemberForAuth() {
		MemberVO saved = dao.selectMemberForAuth("a001");
		assertNotNull(saved);
		System.out.println(saved);
	}

	@Test
	public void testInsertMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectMemberList() {
		Pagination pagination = new Pagination();
		pagination.setCurrentPage(1);
		List<MemberVO> list = dao.selectMemberList(pagination);
		assertNotNull(list);
		assertNotEquals(0, list.size());
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testPuselectMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMember() {
		int rowcnt = dao.deleteMember("a001");
		assertEquals(1, rowcnt);
	}

}
