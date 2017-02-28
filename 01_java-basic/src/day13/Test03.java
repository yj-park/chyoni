package day13;

public class Test03 {
	public static void main(String[] args) {
		/* 권장X
			//try안에는 오류 발생 연관코드 함께 묶어도 됨
		 * try {
		   System.out.println(1);
		   System.out.println(1 / 0); // ArithmeticException
		   System.out.println(2);
		   
		   try {
		   String s = null;
		   System.out.println(s.length()); // NullPointerException
		   System.out.println(3);
		      catch(NullPointerException npe) {
			  npe.printStackTrace();
		      }
		   }
		   catch(ArithmeticException ae) {
		   System.out.println(4);
		   }
		   System.out.println(5);
	     */
		
		
		/*	서로 다른 처리를 위해서 catch문 따로 생성
		    try {
		    System.out.println(1);
			System.out.println(1 / 0); // ArithmeticException
			System.out.println(2);
			String s = null;
			System.out.println(s.length()); // NullPointerException
			System.out.println(3);
			}
		catch(NullPointerException npe) {
			npe.printStackTrace();
		}
		catch(ArithmeticException ae) {
			System.out.println(4);
		}
		System.out.println(5); */
		
		
		
		/*
		 * //똑같은 예외처리문의 경우 
		try {
			System.out.println(1);
			System.out.println(1 / 0); // ArithmeticException
			System.out.println(2);
			String s = null;
			System.out.println(s.length()); // NullPointerException
			System.out.println(3);
		}
		catch(NullPointerException | ArithmeticException ex) {
			ex.printStackTrace();
		}
		System.out.println(4);
		System.out.println(5);
		 */
		
		
		
		 /*
		  * 부모는 자식을 받을 수 있는 묵시적 형변환을 이용한 방법
		  * 가장 편한 방법!! exception이 부모 클래스니까 한 방에 해결
		 try {
			 System.out.println(1);
			 System.out.println(1 / 0); // ArithmeticException
			 System.out.println(2);
			 String s = null;
			 System.out.println(s.length()); // NullPointerException
			 System.out.println(3);
			}
		 catch(Exception ex) {
				ex.printStackTrace();
			}
			System.out.println(5);
			*/
			
		
		// 별도로 catch문에 정의해주는 것을 더 선호함
			try {
				System.out.println(1);
				System.out.println(1 / 0); // ArithmeticException
				System.out.println(2);
				String s = null;
				System.out.println(s.length()); // NullPointerException
				System.out.println(3);
			}
			catch(ArithmeticException ae) {
				ae.printStackTrace();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
			// exception을 위한 catch블럭에서 이미 처리되고 있기 때문에 필요없어라고 오류 발생
			// 위에 선언된 것부터 처리되기 때문에 자식부터 쓰고 부모쓰기
			//catch(ArithmeticException ae) {
			//	ae.printStackTrace();
			System.out.println(5);
	}
}