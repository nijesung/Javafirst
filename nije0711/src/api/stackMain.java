package api;

import java.util.PriorityQueue;
import java.util.Stack;

public class stackMain {

	public static void main(String[] args) {
		
	   Stack <String> stack = new Stack<>(); // Stack = LIFO
	   stack.push("징징이");
	   stack.push("집게사장");
	   stack.push("스폰지밥");
	   stack.push("다람이"); // 뒤에서부터 출력
	   
	   System.out.println(stack.pop());
	   System.out.println(stack.pop());
	   System.out.println(stack.pop());
	   System.out.println(stack.pop());
	   
	   PriorityQueue<String>queue = new PriorityQueue<>();
	   queue.add("what");
	   queue.add("the");
	   queue.add("Fun");
	   queue.add("get out of here");
	   
	   System.out.println(queue.poll()); // 크기가 작은 것부터 리턴
	   System.out.println(queue.poll());
	   System.out.println(queue.poll());
	   System.out.println(queue.poll());
	    

	}

}
