package SWEA_5432_쇠막대기자르기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//테스트케이스 수
		
		for(int t = 0; t < T; t++) {
			String pipe = sc.next();//파이프 문자열
			int total = 0; //파이프 총갯수
			
			MyStack<Character> stack = new MyStack<>();
			for(int i = 0; i < pipe.length(); i++) {
				char c = pipe.charAt(i);
				
				//열린괄호라면
				if(c == '(')
					//레이져 쏘는 부분일때
					if(i + 1 < pipe.length() && pipe.charAt(i + 1) == ')') {
						total += stack.size();
						i++;//i + 1 까지 확인했기때문에 i + 1해줘야 함.
					}
					//아닐때
					else
						stack.push(c);
				//닫힌괄호라면 쇠막대 1개를 끊은것이기 때문에 total + 1
				else {
					total++;
					stack.pop(); //열린괄호 한개 빼내기
				}
			}
			
			//출력
			System.out.println("#" + (t + 1) + " " + total);
		}
		sc.close();
	}
}