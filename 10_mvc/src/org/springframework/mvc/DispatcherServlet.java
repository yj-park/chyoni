package org.springframework.mvc;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private URLHandlerMapping mapping;
	private String prefix, suffix;
	
	public void init(ServletConfig config) throws ServletException {
		// web.xml에 설정된 init-param 태그의 값 접근하기
		// param-name값을 메소드에 넣어주면 param-value값을 반환해줌
		String ctrlNames = config.getInitParameter("controller");
		
		prefix = config.getInitParameter("prefix");
		suffix = config.getInitParameter("suffix");
	//	System.out.println(ctrlNames);
		try {
			mapping = new URLHandlerMapping(ctrlNames);
		} catch (Exception e) {
			// 오류가 발생하면 더 이상 진행하지말고 서버에 알려! 그래서 내가 직접 예외를 발생시키겠어!
			throw new ServletException(e);
		}
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("요청 들어옴");
		
		// POST 방식일 때만 사용하는 게 좋다
		if (request.getMethod().equals("POST")) {
			request.setCharacterEncoding("utf-8");
		}
		
		// 사용자의 요청 URI 얻기
		String requestUri = request.getRequestURI();
		//System.out.println("요청 URI : " + requestUri);
		
		// 업무와 연관된 path 경로 얻기 
		// web context,web application, project명을 배제시킬거야. 왜? 이 경로는 필요없기 때문이지
		String contextPath = request.getContextPath();
		//System.out.println("contextPath : " + contextPath);
		// contextPath.length()부터 끝까지 잘라내줘 
		requestUri = requestUri.substring(contextPath.length());
		System.out.println("requestUri : " + requestUri);
		
		// 컨트롤러 불러오기
		try {
			CtrlAndMethod cam = mapping.getCtrlAndMethod(requestUri);
			//공통이니까 빼주자
			if (cam == null) {
				throw new ServletException("요청하신 URL이 존재하지 않습니다.");
			}
			
			Object target = cam.getTarget();
			Method method = cam.getMethod();
			
			// invoke하기 전 파라미터 처리하기
			// PreparameterProcess 객체를 생성하고
			PreParameterProcess ppp = new PreParameterProcess();
			// 실행할 메소드와 
			Object[] param = ppp.process(method, request);
			
			// invoke하면 object로 받아오기 때문에 반환타입인 ModelAndView로 형변환시키기
			// ModelAndView mav = (ModelAndView)method.invoke(target, param);
			
			// 반환타입 처리
			Class<?> rType = method.getReturnType();
			// rType에 대한 타입 얻을 수 있음. String이냐 ModelAndView냐
			String rName = rType.getSimpleName();
			
			ModelAndView mav = null;
			// 서비스의 반환 타입을 문자열로 바꾸고 넘어갈 페이지 주소를 받아와서 view에 담아줌.
			String view = null;
			switch (rName) {
			case "ModelAndView":
				mav = (ModelAndView)method.invoke(target, param);
				view = mav.getView();
				break;
			case "String":
				view = (String)method.invoke(target, param);
				break;
			case "void":
				method.invoke(target, param);
				// requestUri -> /board/list.do 에서 /를 제외하고 .do를 제외시키면 view
				view = requestUri.substring(1).replace(".do", "");
				break;
			}
			
			// 포워딩이냐 리다이렉트냐 ajax냐 구분
			if (view.startsWith("redirect:")) {
				response.sendRedirect(view.substring("redirect:".length()));
			} 
			else if (view.startsWith("ajax:")) {
				response.setContentType("text/json; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println(view.substring("ajax:".length()));
			}
			// 여기에서만 데이터 공유가 필요
			else {
				if (mav != null) {
					Map<String, Object> model = mav.getModel();
					// Object value = model.get("list"); 이런식으로 꺼낼 수 있지만 우리가 map에 있는 key값을 몰라!
					// map의 key 값 가져오기(model안에 있는 key값을 set에 담아주세요)
					Set<String> keys = model.keySet();
					for (String key : keys) {
						request.setAttribute(key, model.get(key));
					}
				}
				// view의 대상이 되는 조건
				if (!view.endsWith(".do")) {
					view = prefix + view + suffix;
				}
				
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			// 이 내용을 서블릿에 던져줄래요
			throw new ServletException(e);
		}
		
	}
	
	
	
}
