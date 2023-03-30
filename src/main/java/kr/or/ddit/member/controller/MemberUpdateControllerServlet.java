package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import kr.or.ddit.utils.PopulationUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberUpdate.do")
public class MemberUpdateControllerServlet extends HttpServlet {
	private MemberService service = new MemberServiceImpl(); 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO authMember =  (MemberVO) req.getSession().getAttribute("authMember");
//		요청의 디코딩 캐릭터셋 설정.
		req.setCharacterEncoding("UTF-8");
//		요청 파라미터 -> Command Object (request)
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
		
		try {
			PopulationUtils.populate(member, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		member.setMemId(authMember.getMemId());
//		요청 검증
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		
		boolean valid = ValidateUtils.validate(member, errors,UpdateGroup.class);
		String viewName = null;
		if(valid) {
//		통과
//			수정 로직
			ServiceResult result = service.modifyMember(member);
			switch (result) {
			case INVALIDPASSWORD:
//			인증 실패
//				mypage 로 이동(forward) + message
				req.setAttribute("message", "비밀번호 오류");
				viewName = "member/mypage";
				break;
			case OK:
//			수정 성공
//				mypage 로 이동(redirect)
				viewName = "redirect:/mypage.do";	
				break;

			default:
//			실패
				req.setAttribute("message", "서버 오류");
				viewName = "member/mypage";
				break;
			}
			
		}else {
//		불통
//			mypage 로 이동(forward) + errors
			viewName = "member/mypage";
		}
		new InternalResourceViewResolver().viewResolve(viewName, req, resp);
	}
	


}
