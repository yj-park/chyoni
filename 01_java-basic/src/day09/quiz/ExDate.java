package day09.quiz;

public class ExDate {
	private int year;
	private int month;
	private int date;
	// 생성자에 받아온 값은 멤버변수에 무조건 선언한다고 생각
	
	public ExDate() {
		this(2013, 4, 1);
		//this.year = year;
		//this.month = month;
		//this.date = date;	
	}
	public ExDate(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;	
	}
	void showDate() {
		System.out.printf("%d년 %d월 %02d일\n", year, month, date);	
	}
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	
	
}
