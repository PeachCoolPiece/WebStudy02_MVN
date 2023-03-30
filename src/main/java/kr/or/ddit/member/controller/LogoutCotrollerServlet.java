package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.mvc.InternalResourceViewResolver;

@WebServlet("/login/logout")
public class LogoutCotrollerServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.isNew()) {
			resp.sendError(400, "유효 세션이 아님.");
			return;
		}
//		session.removeAttribute("authMember");
		session.invalidate();
		
		String viewName = "redirect:/";
		new InternalResourceViewResolver().viewResolve(viewName, req, resp);
	}
}
