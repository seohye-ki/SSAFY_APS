package Stack2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	//1. 피연산자는?
	//	- 출력
	//2. 연산자는?
	//	- 스택이 비었으면 push
	// 	- 스택이 들어있으면 우선순위가 낮은게 나올때까지 pop, 이후 push
	//3. ( 는?
	//	- push
	//4. ) 는?
	//	- ( 나올때까지 pop
	public static void main(String[] args) {
		String expression = "(6+5*(2-8)/2)";
		String postfix = infixToPostfix(expression);
		System.out.println(postfix);
		
		int result = evalPostfix(postfix);
		System.out.println(result);
		
		System.out.println(evaluate(expression));
	}
	
	//중위표기식을 계산해주는 함수
	static int evaluate(String expression) {
		String postfix = infixToPostfix(expression);
		return evalPostfix(postfix);
	}
	
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
//		map.put('(', 0);
	}
	
	static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			
			//피연산자가 나오면 바로 출력
			if('0' <= c && c <= '9')
				postfix += c;
			//여는 괄호가 나오면 push
			else if(c == '(')
				stack.push(c);
			//닫는 괄호가 나오면 여는 괄호가 나올때까지 pop
			else if(c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			}
			//연산자가 오면 우선순위가 낮은 연산자가 올때까지 pop, ( 여는 괄호는 제외
			else {
				while(!stack.isEmpty() && 
						stack.peek() != '(' &&
						map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}
		
		//스택 비워주기(남은 연산자들)
		while(!stack.isEmpty())
			postfix += stack.pop();
		
		return postfix;
	}
	
	
	//후위표현식 계산하기
	static int evalPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if('0' <= c && c <= '9')
				stack.push(c - '0');
			else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result;
				
				if(c == '+')
					result = num1 + num2;
				else if(c == '-')
					result = num1 - num2;
				else if(c == '*')
					result = num1 * num2;
				else
					result = num1 / num2;
				stack.push(result);
			}
		}
		return stack.pop();
	}
}