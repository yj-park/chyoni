package day12.Bread;

import java.util.Date;

public class BreadDAO {
	private MyArrayList<BreadVO> list = new MyArrayList<>();
	private int no = 0;
	
	public MyArrayList<BreadVO> selectBoard() {
		return list;
	}
	public BreadVO selectOneBoard(int no) {
		for (int i = 0; i < list.size(); i++) {
			BreadVO bread = list.get(i);
			if(bread.getNo() == no) 
				return bread;
		} 
		return null;
	}
	
	public void insertBoard(BreadVO bread) {
		bread.setNo(++no);
		bread.setMadeDate(new Date());
		list.add(bread);
	}
}
