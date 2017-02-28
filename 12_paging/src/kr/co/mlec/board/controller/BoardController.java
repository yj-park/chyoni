package kr.co.mlec.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;
import org.springframework.mvc.RequestMapping;

import com.google.gson.Gson;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.repository.vo.PageResultVO;
import kr.co.mlec.repository.vo.SearchVO;

@Controller
public class BoardController {
	
	private BoardDAO dao;
	
	public BoardController() {
		this.dao = new BoardDAO();
	}
	
	// 2월 24일 2교시: 자유게시판1
	@RequestMapping("/board/list1.do")
	public ModelAndView list1(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		// 마지막 페이지 구하기
//		int lastPage = (count % 10 == 0) ? count / 10 : count / 10 + 1;
//		System.out.println(lastPage);
		
		// 크면서 가장 작은 정수 ceil
		int lastPage = (int)Math.ceil(count / 10d);
		
		ModelAndView mav = new ModelAndView("board/list1");
		// 데이터 공유
		// 목록
		mav.addAttribute("list", list);
		// 전체 게시물 숫자
		mav.addAttribute("count", count);
		// 마지막 페이지 번호
		mav.addAttribute("lastPage", lastPage);
		// 페이지 번호
		mav.addAttribute("pageNo", search.getPageNo());
		return mav;
	}
	
	// 2월 24일 3교시: 자유게시판2 
	@RequestMapping("/board/list2.do")
	public ModelAndView list2(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		// 마지막 페이지
		int lastPage = (int)Math.ceil(count / 10d);
		
		// 목록에 보여질 탭 사이즈 (1~10/11~20/21~30..)
		int tabSize  = 10;
		
		int pageNo = search.getPageNo();
		
		ModelAndView mav = new ModelAndView("board/list2");
		mav.addAttribute("list", list);
		mav.addAttribute("count", count);
		mav.addAttribute("lastPage", lastPage);
		mav.addAttribute("pageNo", pageNo);

		// 현재 페이지에 해당하는 탭 위치, 탭 시작 페이지, 탭 끝 페이지, 이전.다음 페이지 존재 여부 
		// 1~10페이지면 1탭, 11~20페이지면 2탭,...
		int currTab   = (pageNo  -1) / tabSize + 1;
		// 페이지 번호를 구하는 것처럼!
		int beginPage = (currTab -1) * tabSize + 1;
		// 전체페이지보다 작은 경우 currTab이 lastPage가 된다
		int endPage   = (currTab * tabSize < lastPage) ? currTab * tabSize : lastPage;
		// (탭의 첫페이지)beginPage가 1이면 이전으로 옮길 사이트 X
		boolean prev  = beginPage != 1; 
		// (탭의 마지막페이지)lastPage가 endPage가 같으면 이후로 옮길 사이트 X
		boolean next  = endPage != lastPage;

		mav.addAttribute("beginPage", beginPage);
		mav.addAttribute("endPage"  , endPage);
		mav.addAttribute("prev", prev);
		mav.addAttribute("next", next);
		return mav;
	}
	
	// 2월 24일 4교시: 자유게시판3 
	@RequestMapping("/board/list3.do")
	public ModelAndView list3(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		ModelAndView mav = new ModelAndView("board/list3");
		mav.addAttribute("list", list);
		// 게시물 전체 개수, 사용자가 요청한 페이지 번호는 필수템!
		// 저 두 개만 나한테 주면 PageResultVO가 다 계산해서 줄게!
		mav.addAttribute("pageResult", new PageResultVO(search.getPageNo(), count));
		return mav;
	}
	
	// 공통부분 빼서 만들기
	@RequestMapping("/board/list4.do")
	public ModelAndView list4(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		ModelAndView mav = new ModelAndView("board/list4");
		mav.addAttribute("list", list);
		mav.addAttribute("pageResult", new PageResultVO(search.getPageNo(), count));
		return mav;
	}
	
	// custom tag를 통해 원하는 이름으로 바꿔쓰기
	@RequestMapping("/board/list5.do")
	public ModelAndView list5(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		ModelAndView mav = new ModelAndView("board/list5");
		mav.addAttribute("list", list);
		mav.addAttribute("pageResult", new PageResultVO(search.getPageNo(), count));
		return mav;
	}
	
	@RequestMapping("/board/list6.do")
	public String list6(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("pageResult", new PageResultVO(search.getPageNo(), count));
		return "ajax:" + new Gson().toJson(result);
	}
	
	
	public static void main(String[] args) {
		for (int count = 0; count < 100; count++) {
			// 마지막 페이지 구하기
			int p1 = (count % 10 == 0) ? count / 10 : count / 10 + 1;
			int p2 = (int)Math.ceil(count / 10d);
			System.out.println(p1 + "-" + p2);
		}
	}
}










