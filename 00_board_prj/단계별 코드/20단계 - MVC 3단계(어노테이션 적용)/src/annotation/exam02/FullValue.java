package annotation.exam02;

public @interface FullValue {
	String type() default "a";
	String name() default "a";
	String value() default "b";
}