package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// java 1.5이후 위치 지정해주는 방법. annotation방식을 사용해서 간소화함. 꼭 / 필요해 
@WebServlet("/servlet/test02")
public class Test02 implements Servlet {
	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
	}


	// http://localhost:9090/06_servletjsp/servlet/test02
	
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("서비스 메소드 호출됨");
	}

}
