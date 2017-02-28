package ajaxfile;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ajaxfile/exam02")
public class Exam02 extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String upload = "C:/java90/workspace/09_jquery/WebContent/upload";
		MultipartRequest mRequest = 
				new MultipartRequest(
						request, 
						upload, 
						1024 * 1024 * 100, 
						"utf-8", 
						new DefaultFileRenamePolicy());
		
		String msg = mRequest.getParameter("msg");
		System.out.println("일반 데이터(msg) : " + msg);
		/*
		// exam04.html 에서 사용하는 부분 (동적으로 처리되지 않으므로 좋지 않음!)
		String oriFileName = mRequest.getOriginalFileName("attachFile1");
		System.out.println("원본 파일명 : " + oriFileName);
		
		String realFileName = mRequest.getFilesystemName("attachFile1");
		System.out.println("서버 파일명 : " + realFileName);
		
		oriFileName = mRequest.getOriginalFileName("attachFile2");
		System.out.println("원본 파일명 : " + oriFileName);
		
		realFileName = mRequest.getFilesystemName("attachFile2");
		System.out.println("서버 파일명 : " + realFileName);
		
		/*
		*/
		
		
		// exam05.html에서 사용하는 부분
		// Enumeration -> Iterator랑 똑같은 역할 
		// mRequest.getFileNames() -> file 타입의 이름들만 모아서 가져온다
		Enumeration<String> fileNames = mRequest.getFileNames();
		// 가져온 이름값 중 이런 이름값이 있니? 있다면 여기 안에서 실행
		while (fileNames.hasMoreElements()) {
			System.out.println("=============================");
			// nextElement()는 저장된 값을 꺼내올 때 사용
			String fileName = fileNames.nextElement();
			System.out.println("파일 파라미터명 : " + fileName);
			String oriFileName = mRequest.getOriginalFileName(fileName);
			System.out.println("원본 파일명 : " + oriFileName);
			String realFileName = mRequest.getFilesystemName(fileName);
			System.out.println("서버 파일명 : " + realFileName);
		}
		System.out.println("=============================");
		
	}
}










