package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.InternalResourceViewResolver;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")

public class MemberDeleteControllerServlet extends HttpServlet {
   
   private MemberService service = new MemberServiceImpl();
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      HttpSession session = request.getSession();
      	
      
      // 비밀번호 받아오기
      String passWord = request.getParameter("pass");
      
      // 로그인된 비밀번호 가져오기 
      MemberVO authMember =  (MemberVO) request.getSession().getAttribute("authMember");
      String mPass = authMember.getMemPass();
      
      if(StringUtils.isBlank(passWord)) {
    	  response.sendError(400,"필수 파라미터 누락");
    	  return;
      }
   MemberVO input =     MemberVO.builder()
      		.memId(authMember.getMemId())
      		.memPass(passWord)
            .build();
      
      ServiceResult result = service.removeMember(input);
      
    String viewName = null;
      
    switch (result) {
	case INVALIDPASSWORD:
		session.setAttribute("message", "비번 오류");
		viewName = "redirect:/mypage.do";
		break;
	case OK: 
		session.invalidate();
		viewName = "redirect:/";
		break;
	default:
		session.setAttribute("message", "서버 오류");
		viewName = "redirect:/mypage.do";
		break;
	}
      
    	new InternalResourceViewResolver().viewResolve(viewName, request, response);
      
      
  
      
   }
}