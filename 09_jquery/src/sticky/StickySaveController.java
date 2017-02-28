package sticky;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sticky/save.do")
public class StickySaveController extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		
		StickyDao dao = new StickyDao();
		
		StickyVO sticky = new StickyVO();
		sticky.setPosX(x);
		sticky.setPosY(y);
		
		try {
			dao.insert(sticky);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		res.setContentType("text/plain; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(sticky.getId());
		out.close();
	}
	
}
