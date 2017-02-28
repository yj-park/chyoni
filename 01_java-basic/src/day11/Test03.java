package day11;

import java.util.ArrayList;
import java.util.Random;

class Dog {
	String name;
	int age;
	
	Dog() {
		this("이름없음", -1);
	}
	
	Dog(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	//public String toString()
	public String toString() {
		return String.format("Dog[name=%s,age=%d]", name, age);
		
	}
}


public class Test03 {
	public static void main(String[] args) {
		Dog d = new Dog();
		Dog d2 = new Dog("메리", 2);
		System.out.println(d.toString()); 
		//Dog 클래스에는 toString이 없지만 Object를 상속받았기때문에 사용 가능
		//Object.toString()이 호출됨
		//toString() 메소드는 객체 자체를 어떤 식에 대입할 때 자동 호출됨.
		
		System.out.println(d);
		System.out.println(d2);
		
		/* 
		ex)  
		System.out.println(d);
		System.out.println(d.toString());
		두 문장은 서로 같다. 
		"패키지명을 포함한 클래스 명 @ 해쉬코드 값에 대한 16진수"
		*/
		
		int[] arr = {1, 2, 3};
		System.out.println(arr.toString());
		System.out.println(arr);
		/*" [ 대괄호:배열의 차원 수
		        I :정수
		        @ 해쉬코드 값에 대한 16진수 " */
		
		Random r = new Random();
		System.out.println(r.toString());
		System.out.println(r);
		
		ArrayList list = new ArrayList<>();
		System.out.println(list.toString());
		System.out.println(list);
		
		String str = "aaa";
		System.out.println(str.toString());
		System.out.println(str);
		//String 클래스가 오버라이딩해서 재정의했기때문에 aaa가 출력됨.
		//객체가 가지고 있는 정보를 나타내고자 할 때 toString 사용
	}

}
