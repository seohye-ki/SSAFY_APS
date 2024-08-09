package 문제풀이3;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] price = new int[N];
			
			for(int i = 0; i < N; i++) {
				price[i] = sc.nextInt();
			}
			
			long answer = 0;
			
			//max배열을 구해서 처음부터 순회하면서 차액 더해주기
			int[] max = new int[N];
			max[N - 1] = price[N - 1];
			for(int i = N - 2; i >= 0; i--) {
				max[i] = Math.max(price[i], max[i+1]); //사면안될때는 내 가격으로
				answer += (max[i] - price[i]);
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		sc.close();
	}
}
