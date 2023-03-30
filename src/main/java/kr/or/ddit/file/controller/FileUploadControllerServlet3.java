package kr.or.ddit.file.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import kr.or.ddit.file.MultipartFile;
import kr.or.ddit.file.StandardMultipartFile;
import kr.or.ddit.mvc.InternalResourceViewResolver;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
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

@WebServlet("/file/upload3")
@MultipartConfig(fileSizeThreshold = 10240, location = "d:/uploadTemp")
public class FileUploadControllerServlet3 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//	req.getParameterMap();
		Map<String,Object> modelMap = new HashMap<String,Object>();
		String uploader = req.getParameter("uploader");
		modelMap.put("uploader",uploader);
		Part filePart = req.getPart("uploadFile");
		MultipartFile part = new StandardMultipartFile(filePart);
		if(!part.isEmpty()){
			String saveName = processUploadFile(part);
			modelMap.put("savename", saveName);
		}
		req.getSession().setAttribute("modelMap", modelMap);

		String viewName = "redirect:/16/fileUploadForm.jsp";
		new InternalResourceViewResolver().viewResolve(viewName,req,resp);

	}

	private String processUploadFile(MultipartFile part) throws IOException {
		// 1. middle tier 에 저장(web resource 형태,l /resources/files)
		String folderURL = "/resources/files";
		String folderPath = getServletContext().getRealPath(folderURL);
		File saveFolder = new File(folderPath);
		String originalFilename = part.getOriginalFilename();
		String saveName = UUID.randomUUID().toString();
		File saveFile = new File(saveFolder, saveName);
		part.transferTo(saveFile);
		return saveName;
	}
}
