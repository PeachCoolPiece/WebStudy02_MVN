package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.InternalResourceViewResolver;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/mypage.do")
public class MyPageControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		MemberVO authMember =  (MemberVO)req.getSession().getAttribute("authMember");
		MemberVO  member =  service.retrieveMember(authMember.getMemId());
		req.setAttribute("member", member);
		
		String viewName = "member/mypage";
		new InternalResourceViewResolver().viewResolve(viewName, req, resp);
	}
}
