package annotation.exam04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
// 실행 시에는 참조가 되지 않는 어노테이션
@Retention(RetentionPolicy.CLASS)
public @interface ClassAnno {
	String value();
}
