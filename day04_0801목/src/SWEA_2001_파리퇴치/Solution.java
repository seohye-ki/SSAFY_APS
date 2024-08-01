package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //test case
		for(int t = 0;  t < T; t++) {
			int N = sc.nextInt(); //map 크기
			int M = sc.nextInt(); //파리채 면적
			int[][] map = new int[N][N];
			//input map
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			
			//탐색
			int max = 0;
			for(int i = 0; i < N - M + 1; i++) {
				for(int j = 0; j < N - M + 1; j++) {
					if(max < catchFlies(i, j, M, map))
						max = catchFlies(i, j, M, map);
				}
			}
			System.out.println("#" + (t+1) + " " + max);
		}
		sc.close();
	}
	
	//파리잡기
	static int catchFlies(int r, int c, int M, int[][] map) {
		int sum = 0;
		for(int i = r; i < r + M; i++) {
			for(int j = c; j < c + M; j++)
				sum += map[i][j];
		}
		return sum;
	}
}