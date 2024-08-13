package 연결스택구현;

public class Main {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("top에 있는 요소 : " + stack.peek());
		System.out.println("stack의 size : " + stack.size());
		
		System.out.println("pop! " + stack.pop());
		System.out.println("pop! " + stack.pop());
		
		System.out.println("top에 있는 요소 : " + stack.peek());
		System.out.println("stack의 size : " + stack.size());
		
		
		System.out.println("=====================================");
		
		MyStack<String> stack2 = new MyStack<>();
		
		stack2.push("cat");
		stack2.push("dog");
		stack2.push("rabbit");
		stack2.push("monkey");
		stack2.push("mouse");
		System.out.println("top에 있는 요소 : " + stack2.peek());
		System.out.println("stack의 size : " + stack2.size());
		
		System.out.println("pop! " + stack2.pop());
		System.out.println("pop! " + stack2.pop());
		
		System.out.println("top에 있는 요소 : " + stack2.peek());
		System.out.println("stack의 size : " + stack2.size());	
	}
}
