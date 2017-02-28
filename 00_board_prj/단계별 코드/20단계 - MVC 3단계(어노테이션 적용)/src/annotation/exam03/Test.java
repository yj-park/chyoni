package annotation.exam03;

@MyTarget
public class Test {
	
	@MyTarget
	private String name;
	
	@MyTarget
	public void call() {}

	public void call(@MyTarget String name) {}
}
