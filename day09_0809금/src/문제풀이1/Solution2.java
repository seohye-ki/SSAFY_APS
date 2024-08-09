package 문제풀이1;

import java.util.Scanner;

//농작물 : 중앙지점과 거리 차이가 N / 2이하인 칸이면 더해주기
//맨해튼 거리 : Math.abs(r1 - r2) + Math.abs(c1 - c2) <= N / 2
public class Solution2 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(new File("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				String line = sc.next();
				for(int c = 0; c < N; c++) {
					board[r][c] = line.charAt(c) - '0';
				}
			}
			
			int sum = 0;
			
			/*
			 * 채워넣기
			*/
			
			System.out.println("#" + test_case + " " + sum);
		}
		sc.close();
	}
}