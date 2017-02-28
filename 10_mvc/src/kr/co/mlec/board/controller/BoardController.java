package kr.co.mlec.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mvc.ModelAndView;
import org.springframework.mvc.RequestMapping;
import org.springframework.mvc.RequestParam;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.board.vo.PageResultVO;
import kr.co.mlec.board.vo.SearchVO;
import kr.co.mlec.file.MlecFileRenamePolicy;

// 중앙의 컨트롤러를 통해 실행하려했기 때문에 구조적으로 한 클래스에서 처리하지 못했고 우리는 게시판을 개별로 나눴었지만 이제 기능별로 컨트롤러 하나로 합칠거야!
public class BoardController {
	
	private BoardDAO dao;
	public BoardController() {
		this.dao = new BoardDAO();
	}
	
	// @Override를 지웠는데 왜? 예전에는 dispatcher에서 모든 컨트롤러가 상속받고 무조건 service라는 이름의 메소드를 실행할 수 있도록 공통으로 사용하기위해 빼뒀기때문에 필요했었지
	// 이제 메소드명이 기능명을 나타내는 걸로 바꾸자! 
	// 어떻게? RequestMapping으로 이 메소드는 이 url과 연결되어있음을 알려줄 수 있어
	@RequestMapping("/board/commentDelete.do")
	public String commentDelete(BoardCommentVO comment) throws Exception {
		dao.deleteBoardComment(comment.getCommentNo());
		// db결과 바꾼 거 앞에 ajax를 붙이겠다
		return "ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(comment.getNo()));
	}
	
	@RequestMapping("/board/commentList.do")
	public String commentList(int no) throws Exception {
		// ajax로 처리하기위해 페이지 이동 X. 결과를 화면으로 쏴줄 뿐!
		// 하나의 {}가 commentVO의 내용으로 이루어짐
		return "ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(no));
	}
	
	@RequestMapping("/board/commentRegist.do")
	public String commentRegist(BoardCommentVO comment) throws Exception {
		// 게시물 저장 처리 부탁..
		dao.insertBoardComment(comment);
		return "ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(comment.getNo()));
	}
	
	@RequestMapping("/board/commentUpdate.do")
	public String commentUpdate(BoardCommentVO comment) throws Exception {
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		dao.updateBoardComment(comment);
		return "ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(comment.getNo()));
	}
	
	@RequestMapping("/board/delete.do")
	public ModelAndView delete(int no) throws Exception {
		dao.deleteBoard(no);
		
		ModelAndView mav = new ModelAndView("list.do");
		mav.addAttribute("msg", "게시물이 삭제되었습니다");
		
		return mav;
	}
	
	@RequestMapping("/board/detail.do")
	// 파라미터의 이름을 어노테이션을 써서 받아오는 이름이 boardNo지만 no로 쓰고싶은 경우 이런 식으로 사용할 수 있어~
	public ModelAndView detail(@RequestParam(value="no") int no) throws Exception {
		// 게시물 정보 추출
		BoardVO boardVO = dao.selectOneBoard(no);
		// 게시물과 연관된 파일 정보 추출
		BoardFileVO fileVO = dao.selectBoardFileByNo(no);
		
		ModelAndView mav = new ModelAndView("board/detail");
		// Map<String, Object> model = mav.getModel(); 매번 이렇게 설정하면 너무 힘들잖아! 다른 방법 쓸거야 ↓
		mav.addAttribute("boardVO", boardVO);
		mav.addAttribute("file", fileVO);
		return mav;
	}
	
	@RequestMapping("/board/list.do")
	public ModelAndView list(SearchVO search) throws Exception {

		// 공유 데이터 
		List<BoardVO> list = dao.selectBoard(search);
		// 페이징
		int count = dao.selectBoardCount(search);
		
		// 데이터 공유하기
		ModelAndView mav = new ModelAndView("board/list");
		mav.addAttribute("list", list);
		mav.addAttribute("pageResult", new PageResultVO(search.getPageNo(), count));
		// 응답은 DispatcherServlet에서 하니까 
		// RequestDispatcher를 몰라도 할 수 있는거지
		return mav;
	}
	
	@RequestMapping("/board/update.do")
	// 파라미터에 있는 값이 자동 설정된 상태로 클래스 타입 객체로 넘어가는 것 (순수 request 객체가 아닌 것 빼면 다 됨 
	public ModelAndView update(BoardVO board) throws Exception {
		
		/*
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(Integer.parseInt(request.getParameter("no")));
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setContent(request.getParameter("content"));
		dao.updateBoard(boardVO);
		*/
		// 메소드가 자동으로 위의 역할을 수행하도록 만들거야 이제
		/*
		 * BoardVO boardVO = (BoardVO)WebUtil.getParamToVO(request, BoardVO.class);
		 * dao.updateBoard(boardVO);
		 */
		//dao.updateBoard((BoardVO)WebUtil.getParamToVO(request, BoardVO.class));
		dao.updateBoard(board);
		
		ModelAndView mav = new ModelAndView("list.do");
		mav.addAttribute("msg", "게시물이 수정되었습니다");
		return mav;
	}
	
	@RequestMapping("/board/updateForm.do")
	public ModelAndView updateForm(int no) throws Exception {
		// dispatcher가 선작업한 값을 넘겨주니까? ㅠㅠ? 02월22일.1교시 수업
		BoardVO board = dao.selectOneBoard(no);
		ModelAndView mav = new ModelAndView("board/updateForm");
		mav.addAttribute("board", board);
		return mav;
	}
	
	@RequestMapping("/board/write.do")
	public ModelAndView write(HttpServletRequest request) throws Exception {
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
		ModelAndView mav = new ModelAndView("list.do");
		// model 설정
		mav.addAttribute("msg", "게시물이 등록되었습니다");
		
		return mav;
	}
	/*
	@RequestMapping("/board/writeForm.do")
	public String writeForm() throws Exception {
		return "board/writeForm";
	}
	*/
	// /와 .do를 제외하고 경로가 같으면 반환타입이 void여도 가능
	
	@RequestMapping("/board/writeForm.do")
	public void writeForm() throws Exception {
	}
}
