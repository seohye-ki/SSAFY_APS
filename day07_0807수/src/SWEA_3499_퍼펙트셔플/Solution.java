package SWEA_3499_퍼펙트셔플;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			MyQueue<String> queue1 = new MyQueue<>();
			MyQueue<String> queue2 = new MyQueue<>();
			
			//queue에 넣기
			int N = sc.nextInt();
			//짝수개라면 queue1 queue2에 반씩 나눠넣기
			if(N % 2 == 0) {
				for(int i = 0; i < N; i++) {
					if(i < N / 2)
						queue1.add(sc.next());
					else
						queue2.add(sc.next());
				}				
			}
			//홀수개라면 queue1에 (N / 2 + 1)개 queue2에 (N + 1)씩 나눠넣기
			else {
				for(int i = 0; i < N; i++) {
					if(i <= N / 2)
						queue1.add(sc.next());
					else
						queue2.add(sc.next());
				}								
			}
			
			//출력
			System.out.print("#" + (t+1) + " ");
			int i = 0;
			while(i < N) {
				if(i % 2 == 0) //짝수일때는 queue1에서 poll
					System.out.print(queue1.poll() + " ");
				else //홀수일때는 queue2에서 poll
					System.out.print(queue2.poll() + " ");
				i++;
			}
			System.out.println();
		}
		sc.close();
	}
}