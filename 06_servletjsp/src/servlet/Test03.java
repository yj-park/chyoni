package servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// 패키지명+클래스명을 uri로 주면 최소한 중복되지는 않는다!
@WebServlet("/servlet/test03")
public class Test03 extends GenericServlet {
	//public void init(ServletConfig config) {}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("재정의된 service");
	}

}
