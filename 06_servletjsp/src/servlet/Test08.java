package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test08")
public class Test08 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String[] fruits = request.getParameterValues("fruit");
		
		// 체크박스를 사용자가 하나도 체크하지 않는 경우
		// fruits 변수에 null이 입력된다.
		if(fruits!=null){
			for (String fruit : fruits) {
			System.out.println(fruit);
			}
		}
	}

}
