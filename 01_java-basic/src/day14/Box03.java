package day14;

public class Box03<T> {
	// <>안에는 영문자 아무거나 대문자 한 자를 넣어주면되지만!!
	/*
	 * E : Element
	 * K : Key
	 * V : Value
	 * T : Type
	 * N : Number
	 * 
	 * 이런 의미로 쓴다
	 */
	// <>안에 String을 넣어주면 T는 String으로
	// <>안에 Integer를 넣어주면 T는 Integer으로
	
	private T data;
	public Box03() {}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	

}
