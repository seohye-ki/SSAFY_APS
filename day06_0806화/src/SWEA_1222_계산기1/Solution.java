package SWEA_1222_계산기1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			int N = sc.nextInt(); //계산식의 길이
			String str = sc.next(); //문자열 계산식
			
			String postfix = infixToPostfix(str, N);
			
			int result = cal(postfix);
			System.out.println("#" + (t+1) + " " + result);
		}
		sc.close();
	}
	
	//후위표기식으로 바꾸기
	static String infixToPostfix(String str, int N) {
		String postfix = ""; //후위표기식 변수(최종값)
		MyStack<Character> stack = new MyStack<>(); //stack

		for(int i = 0; i < N; i++) {
			char c = str.charAt(i);
			if('0' <= c && c <= '9')
				postfix += c; //바로 출력
			//연산자라면 스택이 비어있으면 push, 아니면 pop하고 push
			else{
				if(!stack.isEmpty())
					postfix += stack.pop();
				stack.push(c);
			}
		}
		
		//스택 비우기(남은 연산자들 꺼내기)
		while(!stack.isEmpty())
			postfix += stack.pop();
		
		return postfix;
	}
	
	//후위표기식 계산하기
	static int cal(String postfix) {
		MyStack<Integer> stack = new MyStack<>();
		
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			//숫자면 stack넣기
			if('0' <= c && c <= '9')
				stack.push(c - '0');
			//연산자면 stack에서 2개 pop해서 계산후 push
			else{
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result = num1 + num2;
				stack.push(result);
			}
		}
		return stack.pop();
	}
}