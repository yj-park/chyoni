package day06.quiz;

class Node {
	int data = 0;
	Node next = null; // 이후 값 찾기.
	Node prev = null; // 이전 값 찾기. double linked list => 검색이 빠름
}

public class Quiz03 {
	public static void main(String[] args) {
		Node head = new Node();		
		head.data = 0;
		Node tail = head;
		
		tail.next = new Node();
		tail.next.data = 10;
		tail = tail.next;

		tail.next = new Node();
		tail.next.data = 20;
		tail = tail.next;
		
		tail.next = new Node();
		tail.next.data = 30;
		tail = tail.next;
		
		Node t = head.next;
		while (t != null) {
			System.out.println(t.data);
			t = t.next;
		}
		
	}

}
