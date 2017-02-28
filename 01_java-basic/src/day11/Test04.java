package day11;

class Animal {
	String name;
	Animal() {}
	Animal(String name) {
		this.name = name;
	}
	void tell() {
		System.out.println("Animal tell");
	}
}

class Cat extends Animal {
	String name;
	Cat() {}
	Cat(String name) {
		this.name = name;
	}
	
	void tell() {
		System.out.println("Cat tell");
	}
	void eat() {
		System.out.println("Cat eat");
	}
}
public class Test04 {
	public static void main(String[] args) {
		Animal a = new Cat("나비");
		System.out.println(a.name);
		a.tell();
		//a.name은 Animal 클래스의 name!
		//오버라이딩은 메소드만 자식클래스를 찾아감
		//a.tell()은 Animal 클래스의 tell이 아닌 Cat클래스의 tell
	}

}
