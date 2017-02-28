package sticky;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/sticky/list.do")
public class StickyListController extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StickyDao dao = new StickyDao();
		List<StickyVO> list = null;
		try {
			list = dao.list();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		res.setContentType("text/plain; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(new Gson().toJson(list));
		out.close();
	}
	
}
