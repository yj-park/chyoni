package O2basic;

// 사용자 개념
public class Test {
	public static void main(String[] args) {
		Tv tv = new SonyTv();
		tv.powerOn();
		tv.powerOff();
		
		tv = new LgTv();
		tv.powerOn();
		tv.powerOff();
	}
}
