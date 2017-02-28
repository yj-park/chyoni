package day12.Exam;

import java.util.Random;

abstract class Shape {
	public abstract void area();
}

class Rectangle extends Shape {
	public void area() {
		System.out.printf("정사각형의 면적은 %d 입니다.\n", );
		
	}
}
class Triangle extends Shape {
	public Triangle(int i) {
		
		
	}
	public void area() {
		System.out.printf("삼각형의 면적은 %d 입니다.\n", );
		
	}
}
class Circle extends Shape {
	public void area() {
		System.out.printf("원의 면적은 %d 입니다.\n", );
		
	}
}
class Square extends Rectangle {
	public Square(int i) {
		
		
	}
	public void area() {
		System.out.printf("직사각형의 면적은 %d 입니다.\n", );
		
	}
}


public class Test01 {
	private int choice() {
		return 1;
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(4)+1;
		// 변수의 다형성: 똑같은 조건에 실행할 때마다 다른 변수가 실행됨
		switch(num) {
		case 1:
			Square s = new Square(r.nextInt(10)+1);
			s.area();
			break;
		case 2:
			Rectangle r = new Square(r.nextInt(10)+1);
			r.area();
			break;
		case 3:
		case 4:
	
		
		}
			
		
	}

}
