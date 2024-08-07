package SWEA_1225_암호생성기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0;  t < 10; t++) {
			int tc = sc.nextInt(); //테스트케이스 번호
			
			//큐생성
			MyQueue<Integer> queue = new MyQueue<>();
			//큐에 원소 넣기
			for(int i = 0; i < 8; i++)
				queue.add(sc.nextInt());
			
			//암호생성하기
			int num = queue.poll(); //첫번째 원소
			out:
			while(true) {
				//한사이클 5번
				for(int i = 1; i <= 5; i++) {
					num -= i; //i만큼 빼기
					//0보다 작거나 같으면 queue에 0넣고 종료
					if(num <= 0) {
						queue.add(0);
						break out;						
					}
					//0보다 크면 queue에 num넣고 다시 숫자 꺼내기
					else {
						queue.add(num);
						num = queue.poll();
					}
				}				
			}
			
			
			//출력
			System.out.print("#" + tc + " ");
			while(!queue.isEmpty())
				System.out.print(queue.poll() + " ");
			System.out.println();
		}
		sc.close();
	}
}