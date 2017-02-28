package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test05")
public class Test05 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 브라우저로 결과보내기
		// 응답할 때 필요한 형태 : 시작라인 + 헤더 + 바디 -> 우리는 바디(content type)만 설정해주면 tomcat이 알아서해줌
		// 응답하려는 Content에 대한 타입을 설정
		// response.setContentType("text/html"); // text/html만 보내면 한글은 깨짐!
		// 1단계 : 응답데이터에 대한 타입 설정
		response.setContentType("text/html; charset=utf-8"); // 브라우저가 해석할 수 없는 타입인 경우 다운로드받으라고 뜨는데 그건 거의 오타난거야
		
		// 2단계 : 사용자에게 데이터를 출력하기 위한 객체 얻기 (11.수요일에는 필요없었던 작업)
		// 소켓과 연결된 출력 객체를 얻어옴
		// OutputStream out = response.getOutputStream(); byte단위 처리 작업(이미지 파일, mp3 등)에 유용
		PrintWriter out = response.getWriter();
		// IO클래스 중 출력만 담당. system.out.print역할(system은 출력 화면에)
		
		// 3단계 : 내용 출력 (연결된 클라이언트로 출력)
		out.println("<html>");
		out.println("<body>");
		out.println(	"<h1>응답 성공</h1>");
		out.println("</body>");
		out.println("</html>");
		
		// 4단계 : 출력 객체 닫기
		out.close();
	}

}
