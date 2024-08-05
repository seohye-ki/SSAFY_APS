package SWEA_1218_괄호짝짓기;

import java.util.Scanner;

public class Solution {
	static char[] stack;
	static int top = -1;
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			int N = sc.nextInt(); //텍스트의 길이
			stack = new char[N];
			String str = sc.next(); //괄호짝짓기 문자열
			
			int result = 1; //결과값 1: 유효, 0: 유효하지 않음
			top = -1; //top값 초기화
			for(int i = 0;  i < str.length(); i++) {
				//유효하지 않으면 반복 종료
				if(result == 0)
					break;
				
				char tmp = str.charAt(i);//한글자씩 확인
				//여는 괄호라면 push
				if(tmp == '(' || tmp == '[' || tmp == '{' || tmp == '<') 
					push(tmp);
				//닫는 괄호라면 pop
				else {
					//스택이 비어있으면
					if(isEmpty()){
						result = 0;
						break;
					}
					//pop 원소와 tmp 원소 매칭
					char item = pop();
					if((tmp == ')' && item == '(') || (tmp == ']' && item == '[') ||
							(tmp == '}' && item == '{') || (tmp == '>' && item == '<'))
						result = 1;
					else
						result = 0;
				}
			}
			//스택에 원소가 남아있다면 유효하지 않음
			if(!isEmpty())
				result = 0;
			System.out.println("#" + (t+1) + " " + result);
		}
		sc.close();
	}
	
	//스택이 비어있는지
	static boolean isEmpty() {
		return top == -1;
	}
	
	//삽입
	static void push(char item) {
		stack[++top] = item;
	}
	
	//삭제
	static char pop() {
		if(isEmpty())
			return 0;
		else
			return stack[top--];
	}
}