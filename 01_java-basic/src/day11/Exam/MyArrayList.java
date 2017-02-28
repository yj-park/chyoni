package day11.Exam;

public class MyArrayList {
	String[] list = new String[4];
	int pos = 0;
	
	public void add(String data) {
		if(pos == list.length) {
			String[] temp = new String[pos * 2];
			System.arraycopy(list, 0, temp, 0, pos);
			list = temp;
		}
		list[pos++] = data;
	}
	public String get(int index) {
		return list[index];
	}
	public int size() {
		return pos;
	}
	public void remove(int index) {
		System.arraycopy(list, index + 1, list, index, pos - (index + 1));
		list[--pos] = null;	
	}
	public void clear() {
		for(int i = 0; i < pos; i++) {
			list[i] = null;
		}
		pos = 0;
	}
	public String toString() {
		String result = "MyArrayList[";
		result += list[0];
		for(int i = 1; i < pos; i++) {
			result += "," + list[i];
		}
		result += "]";
		return result;
	}
	
	
}
