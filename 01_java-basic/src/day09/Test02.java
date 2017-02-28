package day09;

class Sub02 {
	int i = 100;
	static int k = 100;
	// static 블럭: 클래스 정보가 로딩될 때 같이 실행됨
	static { 
		System.out.println("static 블럭이 실행됨");
	}
	Sub02() {
		System.out.println("생성자 호출됨");
	}
}
public class Test02 {
	public static void main(String[] args) {
		System.out.println(0);
		Sub02 s01;
		System.out.println(1);
		System.out.println(Sub02.k);
		Sub02 s02 = new Sub02(); //복사본은 new했을 때 생성.클래스 정보를 참조하기 위해서 Method Area로 간다.
		//갔는데 정보가 없으면 Sub02에 대한 클래스 정보가 로딩
		System.out.println(2);
	}

}
