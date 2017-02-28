package day02;

public class ParseIntTest {
 public static void main(String [] args) {
	
	 System.out.println(args[0]+args[1]); 
	 System.out.println(Integer.parseInt(args[0])+Integer.parseInt(args[1])); 
	
	 int args0 = Integer.parseInt(args[0]); 
	 int args1 = Integer.parseInt(args[1]);
     System.out.println(args0 + args1);	 
     
     //두 수의 합:300
     int sum = args0 + args1; 
     System.out.println("두 수의 합:"+sum); //새로운 변수를 만들어서 더해주는 방법
     System.out.println("두 수의 합:"+(args0+args1)); //우선순위를 정해서 더해주는 방법
     //100+200=300
     
     System.out.println(args0+"+"+args1+"="+(args0+args1)); //문자열과 변수의 값을 함께 출력하려고 하면 +가 많아져서 복잡해지기 때문에 C언어의 방식을 가져와서 쓴다.
 }
}
