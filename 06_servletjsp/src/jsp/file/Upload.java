package jsp.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/jsp/file/upload")
public class Upload extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cos.jar를 사용할 때 API class는 MultipartRequest
		
		// 서버 상의 경로를 upload라는 폴더를 만들어서 줄겡. 경로는 full로 줘야됨. properties에서 locations 복붙하고 \를 /로 바꿔주기
		// 이클립스 소스 관련 작업 디렉토리 활용 -> 업로드시 바로 적용이 되지 않는다.
		// String uploadPath = "C:/java90/workspace/06_servletjsp/WebContent/upload";
		
		// 브라우저에서 바로 볼 수 있게 실제 웹 어플리케이션(컨텍스트,프로젝트)가 실행되는 경로 활용하기
		// String uploadPath = "C:/java90/tomcat-work/wtpwebapps/06_servletjsp/upload";
		
		// (사람마다) 웹 어플리케이션 경로가 다를 수 있기 때문에 동적 경로를 이용하자
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		System.out.println("uploadPath : " + uploadPath);
		// 이클립스에는 적용되지 않지만 실제 폴더에는 바로 인식됨! 
		
		// 날짜별 디렉토리 만들기
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		System.out.println("datePath : " + datePath);
		
		// 날짜만 생성했을뿐 실제 업로드 폴더 밑에 존재하진 않는 중, 존재할 때만 파일을 전송할 수 있으므로 생성해주자!!
		uploadPath += datePath;
		
		// uploadPath에 해당하는 디렉토리가 존재하지 않는다면 생성
		File f = new File(uploadPath);
		if (!f.exists()) {
			// 디렉토리 만드세요~
			f.mkdirs();
		}
		
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				uploadPath, 
				1024 * 1024 * 100, 
				"utf-8", 
				new MlecFileRenamePolicy()
//				new DefaultFileRenamePolicy() 
		);
		// request: 내가 읽어야할 요청을 줘
		// saveDirectory: 서버상의 어떤 경로에 저장할래?
		// maxPostSize: 파일의 최대 용량 제한. 1024*1024*100=100메가
		// encoding: parameter를 어떤걸로 인코딩할래? utf-8로 parameter 인코딩할거야
		// policy: 파일명에 관한 정책. 똑같은 이름의 파일이 업로드 된 경우 어떻게 처리할거니? 
		//         new DefaultFileRenamePolicy()는 cos에서 제공해주는 API. 카운팅해서 만들어줌
		           
		System.out.println("파일이 정상적으로 업로드 되었습니다.");
		
		// 데이터베이스에 정보를 저장하기 위해서 정보 추출하기
		String msg = mRequest.getParameter("msg");
		System.out.println("msg : " + msg);
		
		// 사용자 화면의 file 타입의 name 속성값을 설정
		// <input type="file" name="attachFile" /><br>
		// 사용자가 선택한 이름으로 되어있는 파일 정보를 얻겠다. 형태는 파일이야
		File file = mRequest.getFile("attachFile");
		// file이 null이면 사용자가 파일을 선택하지 않은 경우임 
		// 따라서 file의 정보를 추출하려면 null이 아닌 경우에만 진행한다.
		if (file != null) {
			// 사용자가 선택한 파일 정보 추출하기
			// 사용자가 저장한 파일 이름
			String oriFileName = mRequest.getOriginalFileName("attachFile");
			// 서버에 저장된 파일 이름
			String fileSystemName = mRequest.getFilesystemName("attachFile");
			// 파일의 바이트 크기
			long size = file.length();
			System.out.println("---------------------------");
			System.out.println("oriFileName : " + oriFileName);
			System.out.println("fileSystemName : " + fileSystemName);
			System.out.println("size : " + size);
			System.out.println("---------------------------");
			
			
		}
		
		/* 기본 제공되는 API 사용 불가능 -> 정보가 날아오는 구조가 달라서
		String msg = request.getParameter("msg");
		System.out.println("msg : " + msg);

		String attachFile = request.getParameter("attachFile");
		System.out.println("attachFile : " + attachFile);
		 */
		
		
	}
	
	
	/*
	 * 파일 업로드 스트림 확인용
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 브라우저에 읽어드린 내용을 출력하여 보여주기 위해서 사용
		PrintWriter out = response.getWriter();
		
		// 사용자가 요청한 body의 내용을 읽어올 수 있음
		InputStream in = request.getInputStream();
		// 지정된 InputStream이 가르키는 공간을 읽어내겠다
		Scanner sc = new Scanner(in);
		while (sc.hasNextLine()) {
			out.println(sc.nextLine());
		}
		out.close();
	}
	 */

}
