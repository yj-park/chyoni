package O1basic;

// 사용자 개념
public class Test {
	public static void main(String[] args) {
		SonyTv sTv = new SonyTv();
		sTv.powerOn();
		sTv.powerOff();
		
		LgTv lgTv = new LgTv();
		lgTv.powerOn();
		lgTv.powerOff();
	}
}
