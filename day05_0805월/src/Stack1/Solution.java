package Stack1;

//import java.util.Stack;

public class Solution {
	static String[] stack = new String[100];
	static int top = -1; //마지막에 들어간 데이터의 index를 가리키는 변수
	public static void main(String[] args) {

		//구현된거 가져다가 쓰기
//		Stack<String> stack = new Stack<>();
//		
//		stack.push("cat");
//		stack.push("dog");
//		stack.push("rabbit");
//		
//		for(int i = 0;  i < 3; i++)
//			System.out.println(stack.pop());
		
		//직접 구현한거 가져다 쓰기
		push("cat");
		push("dog");
		push("rabbit");
		while(!isEmpty()) {
			String popItem = pop();
			System.out.println(popItem);
		}
		pop(); //스택이 비어있습니다. 출력
	}
	
	//stack 비어있는지
	static boolean isEmpty() {
//		if(top == -1)
//			return true;
//		return false;
		return top == -1;
	}
	
	//stack 꽉 차있는지
	static boolean isFull() {
		return top == (stack.length - 1);
	}
	
	//삽입
	static void push(String item) {
		if(isFull()) {
			System.out.println("스택이 가득 차있습니다.");
			return;
		}
		stack[++top] = item;
	}
	
	//꺼내기
	static String pop() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top--];
	}
	
	static String peek() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top];
	}
}