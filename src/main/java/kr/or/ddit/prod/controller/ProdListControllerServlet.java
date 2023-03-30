package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import kr.or.ddit.mvc.InternalResourceViewResolver;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.utils.PopulationUtils;
import kr.or.ddit.vo.Pagination;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodList.do")
public class ProdListControllerServlet extends HttpServlet {

	private ProdService service = new ProdServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String pageParam = req.getParameter("page");
		ProdVO detailCondition = new ProdVO();
		
		
		try {
			PopulationUtils.populate(detailCondition, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e); 
		}
	
		
		int currentPage = 1;
		if(StringUtils.isNumeric(pageParam)) {
			currentPage = Integer.parseInt(pageParam);
		}
		
		
		Pagination<ProdVO> pagination = new Pagination<>(2, 2);
		pagination.setCurrentPage(currentPage);
		pagination.setDetailCondition(detailCondition);

		List<ProdVO> prodList = service.retrieveProdList(pagination);
		ObjectMapper mapper = new ObjectMapper();
		
		
		req.setAttribute("pagination", pagination);
		
		String viewName = "prod/prodList";

		new InternalResourceViewResolver().viewResolve(viewName, req, resp);

	}
}
