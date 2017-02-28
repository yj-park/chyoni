package day15.quiz;

public class Data implements Comparable<Data> {
	// <>안에는 비교할 대상을 써야하며 데이터 클래스와 비교할 대상은 또 다른 데이터 클래스
	private int num;
	public Data(int num) {
		this.num = num;
	}
	public int getNum() {return num;}
	public String toString() {return String.valueOf(num);}
	
	@Override
	//Arrays.sort에서 자동으로 부른 메소드
	public int compareTo(Data o) {
		if (this.num == o.getNum()) return 0;
		// 0이면 서로 숫자같으니까 가만히 있어도됨(자리바꿈 없음)
		// 양수면 비교대상보다 뒤로 이동
		// 음수면 비교대상보다 앞으로 이동
		
		// TODO Auto-generated method stub
		// 내림차순
		return this.num > o.getNum() ? -1 : 1;
		
		// 오름차순
		// return this.num > o.getNum() ? 1 : -1;
		
		// 내 숫자값이 작다면 양수값을 넘겨주고 뒤로 감. 음수값을 주면 앞으로 감. 0은 자리이동 X
	}
	
	

}
