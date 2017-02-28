package day07;

public class SingerTest {
	public static void main(String[] args) {
		Singer s1 = new Singer();
		/*
		 * s1.name = "빅뱅";
		 * s1.age = 10;
		 */
		
		// 이렇게 쓰면 안됨! 속성을 직접 접근하는 방법이므로 값에 대한 필터링이 어려움.
		// 범위는 좁게 설정하고 넓혀간다. (처음에는 private -> 멤버변수에 대한 접근이 어려움 -> 메소드를 통해 해결)
	    
		// setter와 getter의 설정 이후
		s1.setName("빅뱅");
		s1.setAge(10);
		// set에서 if문을 통해 age >= 0 라는 조건을 설정한다면
		// s1.setAge(-10)이라는 값이 들어오면 오류라는 것을 알 수 있다!
		
		// 직접 설정하는 것이 아닌 메소드를 통해 설정하는 법
		
		/*
		*System.out.println(s1.name);
		*System.out.println(s1.name);
		*private이 걸려있으니까 당연히 오류 발생
		*/
		
		// 멤버변수는 무조건 private 주는 것으로 습관들이기!!!!!!!!!!!!!!!
		
		System.out.println(s1.getName());
		System.out.println(s1.getAge());
		
		// 멤버변수에 있는 값은 객체가 끝날 때까지 유지, 
		// setter와 getter에 있는 값은 메소드가 끝날 때까지 유지
	
	
	}

}
