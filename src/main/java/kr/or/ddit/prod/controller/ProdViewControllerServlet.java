package kr.or.ddit.prod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.mvc.InternalResourceViewResolver;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

/**
 * 
 * command URI : /prod/prodView.do?what=P101000001
 *
 */

@WebServlet("/prod/prodView.do")
public class ProdViewControllerServlet extends HttpServlet {
	private ProdService service = new ProdServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String prodId = req.getParameter("what");

		if (StringUtils.isBlank(prodId)) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		String viewName = "prod/prodView";
		ProdVO prod = service.retrieveProd(prodId);
		req.setAttribute("prod", prod);

		new InternalResourceViewResolver().viewResolve(viewName, req, resp);

	}
}
