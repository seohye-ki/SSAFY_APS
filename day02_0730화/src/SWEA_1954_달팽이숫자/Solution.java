package SWEA_1954_달팽이숫자;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int cnt = 1;
			int r = 0;
			int c = 0;
			int move = 1;
			while(cnt <= N * N) {
				//오른쪽
				for(int i = 0; i < N - (move / 2); i++) {
					arr[r][c] = cnt;
					c++;
					cnt++;
				}
				r++;
				c--;
				move++;
				//아래	
				for(int i = 0; i < N - (move / 2); i++) {
					arr[r][c] = cnt;
					r++;
					cnt++;
				}
				r--;
				c--;
				move++;
				//왼쪽
				for(int i = 0; i < N - (move / 2); i++) {
					arr[r][c] = cnt;
					c--;
					cnt++;
				}
				r--;
				c++;
				move++;
				//위쪽
				for(int i = 0; i < N - (move / 2); i++) {
					arr[r][c] = cnt;
					r--;
					cnt++;
				}
				r++;
				c++;
				move++;
			}
			//출력
			System.out.println("#" + (t + 1));
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}