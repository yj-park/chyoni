package annotation.exam02;

public @interface FullValue {
	// name에 값이 없는 경우 "a"를 기본값으로 할당하겠다
	String name() default "a";
	String value() default "b";
}
