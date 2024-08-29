package SWEA_2806_NQueen;

import java.util.Scanner;

public class Solution {
	static int N; //놓아야 하는 개수
	static int answer; //경우의 수
	static int[] loc;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			loc = new int[N];
			answer = 0;
			dfs(0);
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
	
	static void dfs(int cnt) {
		if(cnt == N) {
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			loc[cnt] = i; //몇번째 열에 놓았는지 적어둔 배열
			if(check(cnt))
				dfs(cnt + 1);
		}
	}
	
	static boolean check(int cnt) {
		for(int i = 0; i < cnt; i++) {
			//이미 다른행에서 둔 열이라면 못둠.
			if(loc[i] == loc[cnt])
				return false;
			//다른 퀸의 대각선에 위치해 있다면(퀸 끼리의 위치가 대각선위치면 열끼리의 차와 행끼리의 차의 값이 같다)
			else if(Math.abs(cnt - i) == Math.abs(loc[cnt] - loc[i]))
				return false;
		}
		return true;
	}
}