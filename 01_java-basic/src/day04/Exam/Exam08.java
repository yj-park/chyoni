package day04.Exam;

public class Exam08 {
	public static void main(String[] args) {
		int i = 0;
		int k = 0;
		System.out.print("소수: ");
		for(i = 2; i <= 100; i++){
			int count = 0;
			for(k = 1; k <= i; k++){
				if(i % k == 0)count++;
			}
			if (count == 2) {
				System.out.print(i+" "); 
				}
			
			
		}
	}
}

