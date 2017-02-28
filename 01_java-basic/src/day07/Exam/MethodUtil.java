package day07.Exam;



public class MethodUtil {
	
	
	boolean isLowerChar(char c) {
		if (c == 'a'){
			return true;			
		} 
		else {
			return false;
		}
	}
	boolean isUpperChar(char c) {
		if (c == 'a'){
			return false;			
		} 
		else {
			return true;
		}
	}
	int max(int num1, int num2) {
		if (num1 > num2){
			return num1;
		}
		else {
			return num2;
		}
	}
	int min(int num1, int num2) {
		if (num1 > num2){
			return num2;
		}
		else {
			return num1;
		}
	}
	String reverse(String s) {
		return s;
	}
	

}
