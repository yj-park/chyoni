package day14;

import java.util.Random;

import day12.Bread.MyArrayList;

public class Test05 {
	public static void main(String[] args) {
		// Wrapper 클래스
		// 기본형에 대한 참조타입 클래스
		/*
		 * byte 	-> Byte
		 * short	-> Short
		 * int		-> Integer
		 * long 	-> Long
		 * float	-> Float
		 * double	-> Double
		 * boolean	-> Boolean
		 * char		-> Character
		 * 
		 * 클래스가 되는 순간 유용한 메소드가 제공됨
		 * 
		 */
		int i = 100;
		
		// 기본형을 참조형
		Integer iObj = new Integer( i );
		//int 100에 대한 참조형을 만들어라
		
		// 참조형을 기본타입 값으로(원상태로 복구)
		int val = iObj.intValue();
		// (1.4버전까지)참조형만 받을 수 있는 object에는 기본형인 int타입은 들어갈 수 없기 때문에 참조형으로 바꿔서 담아줄 수 있다.
		
		MyArrayList list = new MyArrayList();
		list.add(new Integer(val));
		
		// 1.5버전부터
		// auto boxing - 자동 포장 : 기본형 -> 참조형
		int i2= 100;
		Integer iObj2 = i2;
		// 주소값과 정수값이 다른데 오류가 없으니 즉,자동으로 Integer iBoj2 = new Integer( i2 );가 실행된 것
		// 해당하는 클래스로 바뀜
		
		// auto unboxing - 자동 포장 풀기  : 참조형 -> 기본형
		int i3 = iObj2;
		// iObj2.intValue();가 자동 실행됨
		list.add(i3);
		// MyArrayList에는 Object만 가능한데 int값이 들어간 것
		// Object obj = i3;
		// Object obj = new Integer(i3);
		
		Object obj = 100;
		Object obj2 = "100";
		Random r = new Random();
		
		// 객체는 원래 new해서 만들 수 있는데 자동으로 바뀌었기때문에 오류가 발생하지 않는 것
		System.out.println(obj instanceof Integer);
		// obj가 Integer타입입니까?를 묻는 것 -> obj는 Integer타입이니까 true
		System.out.println(obj2 instanceof Integer);
		// obj2가 Integer타입입니까? -> obj2는 String타입이니까 false
		System.out.println(obj2 instanceof String);
		// obj2가 String타입입니까? -> obj2는 String타입이니까 true
		System.out.println(r instanceof Random);
		// r은 Random타입입니까? -> r은 Random타입이니까 true
		// 상속도 확인 가능!
		
		
		
		
		
		
	}

}
