package SWEA_1222_계산기1;

import java.util.ArrayList;

public class MyStack<T> {
	private int top;
	private ArrayList<T> stack;
	
	public MyStack() {
		this.top = -1;
		this.stack = new ArrayList<>();
	}
	
	//비어있는지
	public boolean isEmpty() {
		return this.top == -1;
	}
	
	//삽입
	public void push(T item) {
		this.top++;
		this.stack.add(top, item);
	}
	
	//꺼내기
	public T pop() {
		if(isEmpty())
			return null;
		else {
			T result = this.stack.get(top);
			this.stack.remove(top);
			this.top--;
			return result;
		}
	}
	
	//top에 있는 값 보여주기(삭제X)
	public T peek() {
			return this.stack.get(top);
	}
}
