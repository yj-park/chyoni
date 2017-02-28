/*
 *  자바 클래스를 웹에서 호출가능하게 하려면
 *  Servlet 인터페이스의 타입으로 만들어야한다.
 */

package servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 11일 수요일에는 우리가 서버를 만들었기 때문에 Servlet 인터페이스를 상속받지 않아도 가능했던 것!
public class Test01 implements Servlet {
	@Override
	// servlet 객체가 메모리에서 해제되기 전 자동호출되는 메소드 (사용할 일 거의 X)
	public void destroy() {
		System.out.println("servlet이 메모리에서 해제될 때 호출");
	}
    // servlet 각각에 대한 환경정보를 얻을 때 활용(사용할 일 거의 X)
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	// 간단한 servlet의 정보를 받기 위해. 관리자 프로그램에서 소개 문구 정도를 받기 위해 (사용할 일 거의 X)
	@Override
	public String getServletInfo() {
		return null;
	}
	// servlet이 처음에 메모리에 등록될 때 최초 한 번만 호출되기 때문에 특별한 작업을 수행하는 역할을 함
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("최초 한 번만 호출되는 메소드 : init()");
	}
	// 사용자의 요청에 대한 처리하는 메소드. 항상 호출됨
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("사용자 요청시마다 호출되는 메소드 : service()");
	}

}
