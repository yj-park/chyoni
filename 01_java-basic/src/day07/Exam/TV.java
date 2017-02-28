package day07.Exam;

public class TV {
	private int volume = 20;
	private int channel = 7;

	void powerOn() {
		System.out.println("티비 전원을 켭니다.");
	}
	public int getVolume() {
		return volume;
	}
	
	public int getChannel() {
		return channel;
	}
	public void setChannel(int _channel) {
		channel = _channel;
	}
	void channelUp() {
		channel++;
	}
	
	void powerOff() {
		System.out.println("티비 전원을 끕니다.");
	}

	
	
}
