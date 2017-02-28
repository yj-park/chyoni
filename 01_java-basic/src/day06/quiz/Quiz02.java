package day06.quiz;

class Bread {
	static int totalPrice;           // 클래스 변수, 멤버변수 앞에 static 클래스마다 할당됨(메모리 하나). 
	String name;                     // 인스턴스 변수: 객체마다 메모리 별도 지정
	int price;
}

public class Quiz02 {
	public static void main(String[] args) {
		
	Bread b1 = new Bread();
	Bread b2 = new Bread();
	
	b1.name = "소보로";
	b1.price = 1000;
	
	b2.name = "단팥빵";
	b2.price = 1500;
	
	Bread[] arr = new Bread[2];
	arr[0] = b1;
	arr[1] = b2;
	
	arr[0].name = "바게트";
	Bread b3 = arr[1];
	b3.price = 3000;
	
	System.out.println(b1.name + " " +b1.price);
	System.out.println(b2.name + " " +b2.price);
		
	
 }

}
