package _05_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// bean으로 등록하기위해 @Component 등록한거야
@Aspect
@Component
public class TimeAspect {
	// around advice일 경우 ProceedingJoinPoint 이용 
	@Around("execution(public * _05_anno.*Controller.execute(..))")
	public void executeTime(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("실행시간 측정 공통 기능 실행 전");
		long s = System.currentTimeMillis();
		// 핵심 기능의 메소드를 호출하는 기능을 담당하는 메소드!!!!!
		try {
			// after-returning 자리
			pjp.proceed();
		} finally {
			// after 자리
			long e = System.currentTimeMillis();
			double time = (e-s) / 1000d;
			System.out.println("실행시간 : " + time);
		}
		/*
		try {
			// after-returning 자리
			pjp.proceed();
		} catch (Throwable t) {
			// after-throwing 자리
		} finally {
			// after 자리
		}
		*/
		System.out.println("실행시간 측정 공통 기능 실행 후");
	}
}
