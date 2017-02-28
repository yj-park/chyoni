package annotation.exam03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// 어노테이션 실행 특정 위치를 지정해주는 메타어노테이션
// TYPE: (클래스,인터페이스,이넘)의 위치에서 쓸 수 있도록 지정
// @Target(value={ElementType.TYPE})
// FIELD: 멤버변수의 위치에서 쓸 수 있도록 지정
// @Target(value={ElementType.FIELD})
// METHOD: 메소드의 위치에서 쓸 수 있도록 지정
// @Target(value={ElementType.METHOD})
// PARAMETER: 파라미터의 위치에서 쓸 수 있도록 지정
// @Target(value={ElementType.PARAMETER})

@Target(value={ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface MyTarget {

}
