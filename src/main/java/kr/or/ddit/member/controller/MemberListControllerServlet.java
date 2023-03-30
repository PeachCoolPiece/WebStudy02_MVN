package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.InternalResourceViewResolver;
import kr.or.ddit.ui.DefaultPaginationRenderer;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.Pagination;
import kr.or.ddit.vo.SimpleCondition;

@WebServlet("/member/memberList.do")
public class MemberListControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String pageParam =  req.getParameter("page");
		String  searchType =  req.getParameter("searchType");
		String  searchWord =  req.getParameter("searchWord");
		SimpleCondition simpleCondition = new SimpleCondition(searchType,searchWord);
	
		int currentPage = 1;
		if(StringUtils.isNumeric(pageParam)){
			currentPage = Integer.parseInt(pageParam);
		}
		
		Pagination<MemberVO> pagination = new Pagination<>(3,2);
		pagination.setCurrentPage(currentPage);
		pagination.setSimpleCondition(simpleCondition);
		List<MemberVO> memberList = service.retrieveMemberList(pagination);
		pagination.setDataList(memberList);
		req.setAttribute("pagination", pagination);
		
		
	//	pagination.setRenderer(new DefaultPaginationRenderer());
		
		String viewName = "member/memberList";
		new InternalResourceViewResolver().viewResolve(viewName, req, resp);
		
	}
}
