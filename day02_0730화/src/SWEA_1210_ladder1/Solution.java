package SWEA_1210_ladder1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		for(int t = 0; t < 10; t++) {
			int tc = sc.nextInt();
			for(int r = 0; r < 100; r++) {
				for(int c = 0;  c < 100; c++)
					map[r][c] = sc.nextInt();
			}
			
			
			//2찾기
			int col = 0;
			for(int i = 0; i < 100; i++) {
				if(map[99][i] == 2) {
					col = i;
					break;
				}
			}
			
			//맨위가 될때 까지 반복
			int row = 98;
			while(row > 0) {
				//왼쪽으로
				if(0 <= col - 1 && map[row][col - 1] == 1) {
					col--;
					while(map[row - 1][col] != 1)
						col--;
					row--;
				}
				//오른쪽으로
				else if(col + 1 < 100 && map[row][col + 1] == 1) {
					col++;
					while(map[row - 1][col] != 1)
						col++;
					row--;
				}
				//위로
				else
					row--;
			}
			System.out.println("#" + tc + " " + col);
		}
		sc.close();
	}
}