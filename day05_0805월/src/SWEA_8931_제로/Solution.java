package SWEA_8931_제로;

import java.util.Scanner;

public class Solution {
	static int[] stack;
	static int top = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();//테스트 케이스
		
		//테스트케이스 수만큼 반복
		for(int tc = 0; tc < TC; tc++) {
			int K = sc.nextInt(); //입력받을 정수 갯수
			stack = new int[K]; //stack 만들기
			//수 받아적기 0이면 기존에 쓴거 지우기
			for(int i = 0; i < K; i++) {
				int item = sc.nextInt();
				if(item == 0)
					pop();
				else
					push(item);
			}
			
			//최종 들어있는 값 합산하기
			int sum = 0;
			while(!isEmpty()) {
				int tmp = pop();
				sum += tmp;
			}
			System.out.println("#" + (tc + 1) + " " + sum);
		}
		sc.close();
	}
	
	//비어있는지
	static boolean isEmpty() {
		return top == -1;
	}
	
	//삽입하기
	static void push(int item) {
		stack[++top] = item;
	}
	
	//꺼내기
	static int pop() {
		if(isEmpty())
			return 0;
		else
			return stack[top--];
	}
}