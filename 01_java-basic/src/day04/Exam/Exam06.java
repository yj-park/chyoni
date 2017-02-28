package day04.Exam;

public class Exam06 {
	public static void main(String[] args) {
		
		System.out.printf(":%4d%4d%4d%4d%4d%4d%4d%4d%4d\n", 1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("--------------------------------------");
		for (int b = 2; b <= 9; b++){
			System.out.print(b + "단");
		  for (int a = 1; a <= 9; a++){
					
				System.out.printf("%4d" , b * a);	
				}
				System.out.println();
			}
		}
	
	}

