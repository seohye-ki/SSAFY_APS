package SWEA_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static Map<Character, Integer> priority = new HashMap<>();
	static {
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			int N = sc.nextInt();
			String str = sc.next();
			
			//후위표기식으로 바꾸기
			String postfix = infixToPostfix(str, N);
			
			//계산하기
			int result = cal(postfix);
			
			//출력
			System.out.println("#" + (t+1) + " " + result);
		}
		sc.close();
	}
	
	//후위표기식으로 바꾸기
	static String infixToPostfix(String str, int N) {
		String postfix = "";//후위표기식으로 변환한 문자열
		MyStack<Character> stack = new MyStack<>();
				
		for(int i = 0; i < N; i++) {
			char c = str.charAt(i);
			//숫자라면 : 출력
			if('0' <= c && c <= '9')
				postfix += c;
			//여는 괄호라면 : 넣기
			else if(c == '(')
				stack.push(c);
			//닫는 괄호라면 : 여는 괄호 나올때까지 pop
			else if(c == ')') {
				char value = stack.pop();
				while(value != '(') {
					postfix += value;
					value = stack.pop();
				}
			}
			//연산자라면 : 우선순위가 낮은 연산자 나올때까지 pop
			else {
				while(!stack.isEmpty() && stack.peek() != '(' &&
						priority.get(stack.peek()) >= priority.get(c))
					postfix += stack.pop();
				stack.push(c);
			}
		}
		
		//stack 비우기
		while(!stack.isEmpty())
			postfix += stack.pop();

		return postfix;
	}
	
	//계산하기
   	static int cal(String postfix) {
   		MyStack<Integer> stack = new MyStack<>();
   		
   		for(int i = 0; i < postfix.length(); i++) {
   			char c = postfix.charAt(i);
   			
   			//숫자라면 : stack에 넣기
   			if('0' <= c && c <= '9')
   				stack.push(c - '0');
   			//연산자라면 : stack에서 2개를 꺼내고 계산한 후 push
   			else {
   				int num1 = stack.pop();
   				int num2 = stack.pop();
   				int result;
   				if(c == '+')
   					result = num1 + num2;
   				else
   					result = num1 * num2;
   				stack.push(result);
   			}
   		}
   		return stack.pop();
   	}
}