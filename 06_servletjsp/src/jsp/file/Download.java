package jsp.file;

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

// 프로젝트에서는 common이나 유틸로 공용페이지로 만들어주기. 한 군데에 저장해야되니까
@WebServlet("/jsp/file/download")
public class Download extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 다운로드를 위한 기본 파라미터
		// path : 파일이 실제 저장된 서버의 경로
		// systemName : 경로에 저장된 실제 파일명
		// downName : 사용자 컴퓨터에 다운로드 시킬 원본 파일명
		
		/*
		 * 다운로드 요청시 : (downName 有)
		 * http://localhost:9090/프로젝트명/jsp/file/download?path=/2017/01/20&systemName=abcd.jpg&downName=국화.jpg
		 * (파일을 읽어서-InputStream으로 브라우저로 보내주면됨!)
		 * 
		 * 이미지 그리기 요청시 : (downName 無)
		 * http://localhost:9090/프로젝트명/jsp/file/download?path=/2017/01/20&systemName=abcd.jpg
		 * (파일을 읽어서 브라우저에 그림을 나타내도록!)
		 */
		
		String path = request.getParameter("path");
		String systemName = request.getParameter("systemName");
		String downName = request.getParameter("downName");
		
		String uploadPath = "C:/java90/tomcat-work/wtpwebapps/06_servletjsp/upload";
		// 이 경로 밑에있는 이 이름의 파일을 읽어라 
		// systemName이 있는 디렉토리가 됨
		File f = new File(uploadPath + path, systemName);
		
		
		// 이미지일 경우 화면에 직접 그린다.
		if (downName == null) {
			response.setHeader("Content-Type", "image/jpg");
			// response.setHeader("Content-Type", "audio/mp3"); 같은 경우도 있음
		}
		// 무조건 다운로드 한다.
		else {
			response.setHeader("Content-Type", "application/octet-stream");
			// 다운도르 파일 이름 헤더 설정
			downName = new String(downName.getBytes("UTF-8"), "8859_1"); //8859-1은 브라우저가 가지고 있는 기본 인코딩 방식
			response.setHeader("Content-Disposition", "attachment;filename=" + downName);
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Length", String.valueOf(f.length()));
		}
		
		// 브라우저에 출력하는 법은 똑같음! (사용자가 지정해준 헤더값에 따라 그리기 or 다운로드로 갈라짐)
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);

		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		while (true) {
			int ch = bis.read();
			if (ch == -1 ) break;
			
			bos.write(ch);
		}
		
		bis.close();
		fis.close();
		bos.close();
		out.close();
		
	}
	

}
