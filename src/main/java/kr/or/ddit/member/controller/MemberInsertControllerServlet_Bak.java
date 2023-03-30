package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.InternalResourceViewResolver;
import kr.or.ddit.vo.MemberVO;

//@WebServlet("/member/memberInsert.do")
public class MemberInsertControllerServlet_Bak extends HttpServlet{
	
	private MemberService service = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String viewName = "member/memberForm"; // logical view name
		new InternalResourceViewResolver().viewResolve(viewName, req, resp);
		
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		MemberVO input = new MemberVO();
		
		input.setMemId(req.getParameter("memId"));
		input.setMemPass(req.getParameter("memPass"));
		input.setMemName(req.getParameter("memName"));
		input.setMemRegno1(req.getParameter("memRegno1"));
		input.setMemRegno2(req.getParameter("memRegno2"));
	//	input.setMemBir(req.getParameter("memBir"));
		input.setMemZip(req.getParameter("memZip"));
		input.setMemAdd1(req.getParameter("memAdd1"));
		input.setMemAdd2(req.getParameter("memAdd2"));
		input.setMemHometel(req.getParameter("memHometel"));
		input.setMemComtel(req.getParameter("memComtel"));
		input.setMemHp(req.getParameter("memHp"));
		input.setMemMail(req.getParameter("memMail"));
		input.setMemJob(req.getParameter("memJob"));
		input.setMemLike(req.getParameter("memLike"));
		input.setMemMemorial(req.getParameter("memMemorial"));
	//	input.setMemMemorialday(req.getParameter("memMemorialday"));
	
		   boolean valid = validate(input);
		      String viewName = null;
		      
		      if(valid) {
		         
		         ServiceResult sr = service.createMember(input);
		         if(sr == ServiceResult.OK) {
		            viewName = "redirect:/";
		         }else {
		            viewName = "member/memberForm";
		         }
		   
		         new InternalResourceViewResolver().viewResolve(viewName, req, resp);

		      }
	}
	
	private boolean validate(MemberVO input) {
		boolean valid = true;
		if(StringUtils.isBlank(input.getMemId())) {
			valid = false;
		}
		if(StringUtils.isBlank(input.getMemPass())) {
			valid = false;
		}
		if(StringUtils.isBlank(input.getMemName())) {
			valid = false;
		}
		
		return valid;
	}
				
}

