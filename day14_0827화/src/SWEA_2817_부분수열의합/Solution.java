package SWEA_2817_부분수열의합;

import java.util.Scanner;

//11 : 30 ~ 11 : 49

public class Solution {
	static int N;
	static int K;
	static int total;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //tc수
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt(); //배열 길이
			K = sc.nextInt(); //기준
			arr = new int[N]; //배열
			
			//input
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			total = 0;
			dfs(0, 0);
			System.out.println("#" + test_case + " " + total);
		}
		sc.close();
	}
	
	static void dfs(int cnt, int sum) {
		if(cnt == N) {
			if(sum == K)
				total++;
			return;
		}
		//포함해서 돌리기
		dfs(cnt + 1, sum + arr[cnt]);
		//포함하지 않고 돌리기
		dfs(cnt + 1, sum);
	}
}