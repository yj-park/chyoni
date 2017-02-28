package day08.quiz.lec;

import java.io.File;
import java.util.Scanner;
// quiz02.txt 파일의 한줄의 영화정보를 바탕으로 설계 
// 마스터:이병헌, 강동원, 김우빈:2016:CJ E&M
class Movie {
	private String name;
	private String actors;
	private int year;
	private String makeCorp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMakeCorp() {
		return makeCorp;
	}
	public void setMakeCorp(String makeCorp) {
		this.makeCorp = makeCorp;
	}
}

public class Quiz02 {
	
	private Movie[] list = new Movie[2];
	private int pos = 0;
	
	public void totalMovieCount() throws Exception {
		System.out.printf("전체 상영된 영화 %d편\n", pos);
	}
	
	public void getMovieCountByNameLength(int len) throws Exception {
		int count = 0;
		for (int i = 0; i < pos; i++) {
			if (list[i].getName().length() == len)
				count++;
		}
		System.out.printf("제목이 %d글자인 영화 %d편\n", len, count);
	}
	
	public void getMovieCountByYear(int year) throws Exception {
		int count = 0;
		for (int i = 0; i < pos; i++) {
			if (list[i].getYear() == year)
				count++;
		}
		System.out.printf("%d년도에 상영한 영화 %d편\n", year, count);
	}
	
	public void loading() throws Exception {
		File f = new File("data/day08/quiz/quiz02.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] arr = line.split(":");
			Movie m = new Movie();
			m.setName(arr[0]);
			m.setActors(arr[1]);
			m.setYear(Integer.parseInt(arr[2]));
			m.setMakeCorp(arr[3]);
			
			if (pos == list.length) {
				Movie[] temp = new Movie[pos * 2];
				System.arraycopy(list, 0, temp, 0, pos);
				list = temp;
			}
			
			list[pos++] = m;
		}
	}

	
	public static void main(String[] args) throws Exception {
		Quiz02 quiz = new Quiz02();
		// 최초에 공통으로 사용되는 파일의 내용을 읽어서 메모리에 올리기
		// 메모리 공간 : 배열
		quiz.loading();
		// 전체 상영된 영화 카운트
		quiz.totalMovieCount();
		// 제목이 지정된 글자수와 같은 영화
		quiz.getMovieCountByNameLength(2);
		// 영화 상영 년도를 기준으로 카운트 조회
		quiz.getMovieCountByYear(2015);
	}

}











