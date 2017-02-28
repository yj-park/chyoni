package ajaxfile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/ajaxfile/exam01")
public class Exam01 extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String upload = "C:/java90/workspace/09_jquery/WebContent/upload";
		// 외부라이브러리(cos)에 들어있는 클래스
		MultipartRequest mRequest = 
				new MultipartRequest(
						// 업로드 한 파일 정보 
						request, 
						// save 폴더 경로
						upload, 
						// 파일 최대 크기
						1024 * 1024 * 100, 
						// 인코딩
						"utf-8",
						// 파일 이름. rename처리
						new DefaultFileRenamePolicy());
		
		// 파일 업로드 시 포맷 자체가 다르기 때문에 파싱한 API 클래스를 이용해 가져와야함
		String msg = mRequest.getParameter("msg");
		System.out.println("일반 데이터(msg) : " + msg);
		
		// 화면의 input type="file"일 때 name 부분
		String oriFileName = mRequest.getOriginalFileName("attachFile");
		System.out.println("원본 파일명 : " + oriFileName);
		
		// 서버에 저장된 파일명
		String realFileName = mRequest.getFilesystemName("attachFile");
		System.out.println("서버 파일명 : " + realFileName);
		
		oriFileName = mRequest.getOriginalFileName("attachFile1");
		System.out.println("원본 파일명 : " + oriFileName);
		
		realFileName = mRequest.getFilesystemName("attachFile1");
		System.out.println("서버 파일명 : " + realFileName);
	}
}










