package SWEA_1954_달팽이숫자;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 개수
		for(int t = 0;  t < T; t++) {
			int N = sc.nextInt(); //달팽이 크기
			int[][] snail = new int[N][N];
			int num = 1;
			int r = 0; //row
			int c = 0; //column
			int flag = 1; //1: 오른쪽, 2: 아래, 3: 왼쪽, 4:위
			while(num <= N * N) {
				//오른쪽으로
				if(flag == 1) {
					snail[r][c++] = num;
					if(N <= c || snail[r][c] != 0) {
						flag = 2;
						r++;
						c--;
					}
				}
				//아래쪽으로
				else if(flag == 2) {
					snail[r++][c] = num;
					if(N <= r || snail[r][c] != 0) {
						flag = 3;
						r--;
						c--;
					}
				}
				//왼쪽으로
				else if(flag == 3) {
					snail[r][c--] = num;
					if(c < 0 || snail[r][c] != 0) {
						flag = 4;
						r--;
						c++;
					}
				}
				//위쪽으로
				else {
					snail[r--][c] = num;
					if(snail[r][c] != 0) {
						flag = 1;
						r++;
						c++;
					}
				}
				num++;
			}
			
			//출력
			System.out.println("#" + (t+1));
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}