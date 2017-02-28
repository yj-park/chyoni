package annotation.exam04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
// 실행 시점에 참조할 수 있는 어노테이션
@Retention(RetentionPolicy.RUNTIME)
public @interface RunAnno1 {
	String value();
}
