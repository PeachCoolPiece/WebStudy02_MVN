package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.InternalResourceViewResolver;
import kr.or.ddit.vo.MemberVO;

/**
 * ex) /member/memberView.do?who=a001
 *
 */
@WebServlet("/member/memberView.do")
public class MemberViewControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); // 1. 중복
		
		String memId = req.getParameter("who");
		if(StringUtils.isBlank(memId)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "필수 파라미터 누락");
			return;
		}
		
		MemberVO member = service.retrieveMember(memId);
		
		req.setAttribute("member", member);
		
		// 2. 중복
		String viewName = "member/memberView";
		new InternalResourceViewResolver().viewResolve(viewName, req, resp);
	}
}










