package day05;

public class Test01 {
	public static void main(String[] args) {
		int[] iArr;
		iArr = new int[10];
		
		/* 반복문 사용해서 만들 것	
		iArr[0] = 10;
		iArr[1] = 20;
		iArr[2] = 30;
		iArr[3] = 40;
		 */	
		/*
		System.out.println(iArr[0]);
		System.out.println(iArr[1]);
		System.out.println(iArr[2]);
		System.out.println(iArr[3]);
		*/
		
		//동적인 코드로 만들 것
		for(int index = 0; index < iArr.length; index++){
			iArr[index] = (index + 1) * 10;
		} 
		for (int index = 0; index < iArr.length; index++){
			System.out.println(iArr[index]);
		}
		
		String[] sArr = new String[4];
		
		for (int index = 0; index < sArr.length; index++){
			System.out.println(sArr[index]);
		}
		sArr[1] = "java";			
		for (int index = 0; index < sArr.length; index++){
			System.out.println(sArr[index]);
		}
				
	}

}
