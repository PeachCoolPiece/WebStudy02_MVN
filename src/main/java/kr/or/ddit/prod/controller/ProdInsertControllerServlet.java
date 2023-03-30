package kr.or.ddit.prod.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.file.MultipartFile;
import kr.or.ddit.file.StandardMultipartFile;
import kr.or.ddit.mvc.InternalResourceViewResolver;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.utils.PopulationUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodInsert.do")
@MultipartConfig(fileSizeThreshold = 10240, location = "d:/uploadTemp")
public class ProdInsertControllerServlet extends HttpServlet{
	
	private ProdService service = new ProdServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "prod/prodForm";
		new InternalResourceViewResolver().viewResolve(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProdVO prod = new ProdVO();
		req.setAttribute("prod", prod);
		
		try {
			PopulationUtils.populate(prod, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
	
		
		Map<String, List<String>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		// 1. prodImage 확보
		Part prodImage = req.getPart("prodImage");// 인풋 태그 name
		if(prodImage!=null){
		// 2. MultipartFile 캡슐화(wrapping)
		MultipartFile imageFile = new StandardMultipartFile(prodImage);
		if( ! imageFile.isEmpty()){
		// 3. 저장 -> metadata 확보 : prodcessProdImage 호출
		String savename = processProdImage(imageFile);
		// 4. prodImg 에 matadata 저장
		prod.setProdImg(savename);

			}
		}
		// prodImg 검증
		ValidateUtils.validate(prod, errors, InsertGroup.class);

		String viewName = null;
		if (errors.isEmpty()) {
			ServiceResult result = service.createProd(prod);
			switch (result) {
			case OK:
				viewName = "redirect:/prod/prodView.do?what=" + prod.getProdId();
				break;
			default:
				req.setAttribute("message", "서버 오류");
				viewName = "prod/prodForm";
				break;
			}
		} else {
			viewName = "prod/prodForm";
		}
		new InternalResourceViewResolver().viewResolve(viewName, req, resp);
	}

	private String processProdImage(MultipartFile prodImage) throws IOException {
		// 1. middle tier 에 저장(web resource 형태,l /resources/files)
		String folderURL = "/resources/prodImages";
		String folderPath = getServletContext().getRealPath(folderURL);
		File saveFolder = new File(folderPath);
		String originalFilename = prodImage.getOriginalFilename();
		String saveName = UUID.randomUUID().toString();
		File saveFile = new File(saveFolder, saveName);
		prodImage.transferTo(saveFile);
		return saveName;
	}
}



