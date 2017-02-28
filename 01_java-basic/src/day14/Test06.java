package day14;


public class Test06 {
	public static void main(String[] args) {
		Box01 b = new Box01();
		b.setData("test");
		String data = b.getData();
		System.out.println("data : " + data);
		// Box01은 문자열 데이터만 받을 수 있기 때문에 다른 타입의 데이터를 받기 위해서 여러 박스를 만들어야해서 번거롭넹 but 꺼내긴 쉬움
	
		Box02 b2 = new Box02();
		b2.setData("test");
		String data2 = (String)b.getData();
		System.out.println("data : " + data2);

		b2.setData(100);
		Integer data3 = (Integer)b2.getData();
		// Box02는 Object를 받을 수 있으므로 모든 타입을 받을 수 있지 but 꺼낼때마다 형변환을 시켜줘야해서 좀 번거롭넹
		System.out.println("data : " + data3);
		
		// Box01+Box02의 장점만 모아둔 Box03 -> Generic
		// <>표시가 있으면 Generic을 썼구나 할 수 있음
		// Box03 b3 = new Box03();
		// Box03 is a raw type. References to generic type Box03<T> should be parameterized
		// 클래스가 Generic으로 선언되어있음에도 불구하고 니가 그 형태로 쓰고 있지 못하고 있어!라고 말해주는 중
		Box03<String> b3 = new Box03<String>();
		//<String>이 <T>로 간다고 생각해
		b3.setData("test");
		String data4 = b3.getData();
		System.out.println("data : " + data4);
		//<>를 통해 모든 타입을 받아올 수 있고 꺼낼때도 그에 맞는 타입으로 그대로 보내줄 수 있다!!
		Box03<Integer> b4 = new Box03<Integer>();
		
		Box04<String, String> box04 = 
				new Box04<String, String>("apple", "사과");
		//<String, String>은 Box04<K,V>를 보고 
		//("apple","사과")는 K key, V value
		System.out.println(box04.getKey());
		System.out.println(box04.getValue());
		
		//1.7부터 generic 간소화되어 뒤에 있는 <>는 생략 가능
		Box04<String, String> b5 = 
				new Box04<>("apple", "사과");
		
		
		
		
	}
			

}
