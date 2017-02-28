package O3basic;

// 사용자 개념
public class Test {
	public static void main(String[] args) {
		// 갈수록 유연해지긴 하지만 어쩔 수 없이 new를 피할 수는 없어
		// TvFactory에 대한 의존성이 커짐
		TvFactory factory = new TvFactory();
		// TvFactory의 역할을 하는 것이 스프링의 컨테이너!
		Tv tv = factory.getBean("sony");
		tv.powerOn();
		tv.powerOff();
		
		tv = factory.getBean("lg");
		tv.powerOn();
		tv.powerOff();
	}
}
