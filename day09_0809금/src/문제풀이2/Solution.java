package 문제풀이2;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = 9;
			int[][] sudoku = new int[N][N];
			
			//input
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					sudoku[r][c] = sc.nextInt();
				}
			}
			int answer = check(N, sudoku);
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
	
	static int check(int N, int[][] sudoku) {
		//행 검증
		for(int r = 0; r < N; r++) {
			int[] count = new int[10];
			for(int c = 0; c < N; c++) {
				int num = sudoku[r][c];
				if(count[num] == 1)
					return 0;
				count[num] = 1;
			}
		}
		
		//열 검증
		for(int c = 0; c < N; c++) {
			int[] count = new int[10];
			for(int r = 0; r < N; r++) {
				int num = sudoku[r][c];
				if(count[num] == 1)
					return 0;
				count[num] = 1;
			}
		}
		
		//3X3영역 검증
		int[][][] count = new int[3][3][10];
		for(int r = 0; r < N; r++){
			for(int c = 0; c < N; c++) {
				int num = sudoku[r][c];
				int i = r / 3;
				int j = c / 3;
				if(count[i][j][num] == 1)
					return 0;
				count[i][j][num] = 1;
			}
		}
		return 1;
	}
}
