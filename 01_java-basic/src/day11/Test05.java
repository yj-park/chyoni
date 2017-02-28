package day11;

class Food {	
}

class Tonkatsu extends Food {	
}

class Pizza extends Food {	
}


public class Test05 {
	public static void main(String[] args) {
	 // Tonkatsu ton = new Food(); ->컴파일시 오류 발생. 자식은 부모를 그냥 받을 수 없다
	 // Tonkatsu ton = (Tonkatsu)new Food(); ->실행 시 오류 발생. food에는 tonkatsu의 관계가 없기 때문
	 // 올바른 명시적 형변환은 묵시적인 형변환이 이루어진 객체를 대상으로 함 (원상태로 다시 되돌릴 때 사용)
	
	
	    // 묵시적 형변환 객체 
		Food f = new Tonkatsu();
		
		// 명시적 형변환 객체
		Tonkatsu ton = (Tonkatsu)f;
		Pizza p = (Pizza)f; // 실행 시 오류 발생. 돈가스를 피자로 바꿀 수 없어.
	
	
	
	}

}
