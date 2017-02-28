package kr.co.mlec.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/file/download")
public class Download extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 다운로드를 위한 기본 파라미터
		// path : 파일이 실제 저장된 서버의 경로
		// systemName : 경로에 저장된 실제 파일명
		// downName : 사용자 컴퓨터에 다운로드 시킬 원본 파일명
		
		/*
		 *  다운로드 요청시 :
		 *  /프로젝트명/jsp/file/download?path=/2017/01/20&systemName=abcd.jpg&downName=국화.jpg
		 *  
		 *  이미지 그리기 요청시 : 
		 *  /프로젝트명/jsp/file/download?path=/2017/01/20&systemName=abcd.jpg
		 */
		String path = request.getParameter("path");
		String systemName = request.getParameter("systemName");
		String downName = request.getParameter("downName");
		
		String uploadPath = "C:/java90/tomcat-work/wtpwebapps/06_servletjsp/upload";
		File f = new File(uploadPath + path, systemName);
		
		// 이미지일 경우 화면에 직접 그린다.
		if (downName == null) {
			response.setHeader("Content-Type", "image/jpg");
		}
		// 무조건 다운로드 한다.
		else {
			response.setHeader("Content-Type", "application/octet-stream");
			// 다운로드 파일 이름 헤더 설정
			downName = new String(downName.getBytes("UTF-8"), "8859_1");
			response.setHeader(
					"Content-Disposition", "attachment;filename=" + downName);
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Length", String.valueOf(f.length()));
		}
		
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		while (true) {
			int ch = bis.read();
			if (ch == -1) break;
			
			bos.write(ch);
		}
		bis.close();
		fis.close();
		bos.close();
		out.close();
	}
}