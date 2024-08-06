package SWEA_5432_쇠막대기자르기;

import java.util.ArrayList;

public class MyStack<T> {
	private int top;
	private int size;
	private ArrayList<T> stack;
	
	public MyStack() {
		this.top = -1;
		this.size = 0;
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
		this.size++;
	}
	
	//꺼내기
	public T pop() {
		if(isEmpty())
			return null;
		else {
			T result = this.stack.get(top);
			this.stack.remove(top);
			this.top--;
			this.size--;
			return result;
		}
	}
	
	//top에 있는 값 보여주기(삭제X)
	public T peek() {
		return this.stack.get(top);
	}
	
	//stack에 들어있는 값
	public int size() {
		return this.size;
	}
}
