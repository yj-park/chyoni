package _04_schema;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

// BoardController, MemberController가 실행될 때 공통으로 실행할 코드
public class LogAspect {
	public void showLog(JoinPoint point) {
		// 핵심 기능 클래스
		// target은 핵심 기능 클래스 객체를 나타냄
		Object target = point.getTarget();
		// reflection을 사용하여 이름 가져오기 3번째 방법인 생성된 객체.getClass()
		Class<?> clz = target.getClass();
		
		// 핵심 기능 클래스의 메소드
		// 메소드의 정보를 가지고있는 Signature
		Signature sign = point.getSignature();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("--------------------------------------");
		System.out.println("클래스명 : " + clz.getName());
		System.out.println("메소드명 : " + sign.getName());
		System.out.println("호출 시간 : " + sdf.format(new Date()));
		System.out.println("--------------------------------------");
	}
}
