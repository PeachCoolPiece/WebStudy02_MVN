package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.exception.AuthenticateException;
import kr.or.ddit.member.service.AuthenticateService;
import kr.or.ddit.member.service.AuthenticateServiceImpl;
import kr.or.ddit.mvc.InternalResourceViewResolver;
import kr.or.ddit.vo.MemberVO;

/**
 * 1. 둘중의 하나 혹은 모든 파라미터가 누락되면, 400 에러 전송
 * 2. 인증 실패라면, loginForm으로 이동("로그인에 실패했음"  공유, attribute name : message) 
 * 		-> loginForm에서 "로그인에 실패했음" 이라는 메시지를 swal 로 출력.
 * 3. 인증 성공시, 웰컴 페이지로 이동 (인증에 성공한 사용자의 VO를 공유, attribute name : authMember).
 * 		-> "김은대님 로그인" 메시지 출력.
 *
 */
@WebServlet("/login/loginProccess")
public class LoginProcessControllerServlet extends HttpServlet{
	private AuthenticateService service = new AuthenticateServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.isNew()) {
			resp.sendError(400);
			return;
		}
			
		req.setCharacterEncoding("UTF-8");
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		
		MemberVO input = new MemberVO(); // command object
		input.setMemId(memId);
		input.setMemPass(memPass);
		
		boolean valid = validate(input);
		String viewName = null;
		if(valid) {
			try {
				MemberVO saved = service.authenticate(input);
				session.setAttribute("authMember", saved);
				viewName = "/";
			}catch (AuthenticateException e) {
				String message = "로그인 실패";
				session.setAttribute("message", message);
				viewName = "/login/loginForm.jsp";
			}
		}else {
			session.setAttribute("message", "필수 파라미터 누락");
			viewName = "/login/loginForm.jsp";
		}
		
		viewName = "redirect:"+viewName;
		new InternalResourceViewResolver().viewResolve(viewName, req, resp);
	}

	private boolean validate(MemberVO input) {
		boolean valid = true;
		if(StringUtils.isBlank(input.getMemId())) {
			valid = false;
		}
		if(StringUtils.isBlank(input.getMemPass())) {
			valid = false;
		}
		return valid;
	}
}
















