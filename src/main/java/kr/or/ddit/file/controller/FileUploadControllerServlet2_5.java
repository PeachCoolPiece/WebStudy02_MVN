package kr.or.ddit.file.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
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
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file/upload2_5")
public class FileUploadControllerServlet2_5 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File tmpRepository = new File("D:/uploadTemp");
		int threshold = 10 * 1024;

		FileItemFactory itemFactory = new DiskFileItemFactory(threshold,tmpRepository);
		ServletFileUpload handler = new ServletFileUpload(itemFactory);
		try {
			List<FileItem> itemList = handler.parseRequest(req);
			for (FileItem part : itemList) {
				if(part.isFormField()){
					String parameterValue = part.getString("UTF-8");
					System.out.printf("파라미터 형태로 처리함 : %s \n", parameterValue);
				}else {
					boolean empty = StringUtils.isBlank(part.getName());
					if(empty) continue;

					String metadata =  processUploadFile(part);
					System.out.printf("저장된 파일명 : %s\n",metadata);
				}
			}
		} catch (FileUploadException e) {
			throw new RuntimeException(e);
		}

	}

	private String processUploadFile(FileItem part) throws IOException {
		// 1. middle tier 에 저장(web resource 형태,l /resources/files)
		String folderURL = "/resources/files";
		String folderPath = getServletContext().getRealPath(folderURL);
		File saveFolder = new File(folderPath);
		String originalFilename = part.getName();
		String saveName = UUID.randomUUID().toString();
		File saveFile = new File(saveFolder, saveName);
		try(
				InputStream is = part.getInputStream()
		){
			FileUtils.copyInputStreamToFile(is,saveFile);
			// 2. 저장 경로나 이름을 포함 하고 있는 metadata 생성됨 -> DB 등에 저장
			return saveName;
		}

	}
}
