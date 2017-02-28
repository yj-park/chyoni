package kr.co.mlec.board.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.file.MlecFileRenamePolicy;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private BoardDAO dao;
	public WriteServlet() {
		this.dao = new BoardDAO();
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/upload");
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = path + datePath;
		File f = new File(savePath);
		if (!f.exists()) f.mkdirs();
		
		// 파일 처리를 위한 API 클래스 호출
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				savePath, 
				1024 * 1024 * 10, 
				"UTF-8",
				new MlecFileRenamePolicy()
		);
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		
		BoardVO board = new BoardVO();
		board.setTitle(mRequest.getParameter("title"));
		board.setWriter(mRequest.getParameter("writer"));
		board.setContent(mRequest.getParameter("content"));
		
		// 게시물 저장 처리 부탁..
		BoardDAO dao = new BoardDAO();
		int no = dao.insertBoard(board);
		
		File file = mRequest.getFile("attachFile");
		if (file != null) {
			String oriName = mRequest.getOriginalFileName("attachFile");
			String systemName = mRequest.getFilesystemName("attachFile");
			long fileSize = file.length();
			
			BoardFileVO boardFile = new BoardFileVO();
			boardFile.setNo(no);
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
			boardFile.setFilePath(datePath);
			boardFile.setFileSize(fileSize);
			
			dao.insertBoardFile(boardFile);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/board/write.jsp");
		rd.forward(request, response);
		
	}
}
