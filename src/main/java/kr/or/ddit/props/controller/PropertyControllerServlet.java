package kr.or.ddit.props.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.props.service.PropertyService;
import kr.or.ddit.props.service.PropertyServiceImpl1;
import kr.or.ddit.props.vo.PropertyVO;
import kr.or.ddit.utils.RequestBodyProcessor;

@WebServlet(value = "/props", loadOnStartup = 1)
public class PropertyControllerServlet extends HttpServlet{
	
	private PropertyService service = new PropertyServiceImpl1();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.printf("주입된 객체 : %s\n", service.getClass().getName());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PropertyVO delProp = RequestBodyProcessor.getContentFromRequestBody(req, PropertyVO.class);
		boolean result = service.removeProperty(delProp);
		if(result) {
			doGet(req, resp);
		}else {
			req.setAttribute("error", 404);
			req.setAttribute("message", "삭제 실패");
			req.getRequestDispatcher("/jsonView.view").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<PropertyVO> list = service.retrieveProperties(null);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsonView.view").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PropertyVO newProp = RequestBodyProcessor.getContentFromRequestBody(req, PropertyVO.class);
		service.createProperty(newProp);
		resp.sendRedirect(req.getContextPath() + "/props");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PropertyVO modifyProp = RequestBodyProcessor.getContentFromRequestBody(req, PropertyVO.class);
		boolean result = service.modifyProperty(modifyProp);
		if(result) {
			req.setAttribute("status", 302);
			req.setAttribute("location", req.getContextPath() + "/props");
		}else {
			req.setAttribute("error", 500);
			req.setAttribute("message", "수정 실패");
		}
		req.getRequestDispatcher("/jsonView.view").forward(req, resp);
	}

}















