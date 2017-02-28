package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test02 {
	public static void main(String[] args) {
		try {
			// 예외가 발생할 수 있는 코드를 try에 넣고 블럭{}으로 넣어줌
			/* 1. JVM은 해당 예외상황과 관련된 예외 클래스를 찾는다.
			 * 2. 해당 예외클래스 객체를 메모리에 생성한다. (new FileNotFoundException(..))
			 * 3. 발생한 예외를 처리할 수 있는 catch문이 있는지 찾는다.
			 * 4. 처리할 수 있는 catch문이 있다면 발생된 예외 객체를 넘겨준다.
			 * 5. catch문에 예외처리 구문을 작성한다.
			 */
			FileReader fr = new FileReader("a.txt");
			// 파일은 프로젝트 바로 밑에서 찾는다.
		}	// catch : 발생한 예외를 처리할 수 있는 코드를 묶어주는 역할
		catch(FileNotFoundException fnfe) {
			// catch문의 예외처리 구문의 특별한 형식이 정해져있는 것은 아님(대표 방식 2가지)
			// 1. 발생된 예외 정보를 간단하게 확인하기
			System.out.println(fnfe.getMessage());
			// 2. 상세한 정보를 출력하기 위해서 사용(예외 처리의 근본적인 이유는 예외를 없애기 위해서니까!) 
			fnfe.printStackTrace();
		} 
		
	}

}
