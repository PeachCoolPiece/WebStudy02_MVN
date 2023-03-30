package kr.or.ddit.schema.controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.schema.service.SchemaService;
import kr.or.ddit.schema.service.SchemaServiceImpl;
import kr.or.ddit.vo.TableSchemaVO;


@WebServlet("/schema/tableSchema")
public class TableSchemaControllerServlet extends HttpServlet{
	private SchemaService service;
	AppConfig appconfig = new AppConfig();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service = appconfig.schemaService();
		List<TableSchemaVO> tableList =  service.retrieveTableSchmaList();
		req.setAttribute("tableList", tableList);
		String viewName = "/jsonView.view";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
}
