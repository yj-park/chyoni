package O3basic;

public class TvFactory {
	public Tv getBean(String name) {
		
		switch (name) {
		case "sony":
			return new SonyTv();
		case "lg":
			return new LgTv();
		}
		return null;
	}
}
