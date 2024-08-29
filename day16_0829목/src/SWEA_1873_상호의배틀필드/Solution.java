package SWEA_1873_상호의배틀필드;

import java.util.Scanner;

public class Solution {
	static int H; //행
	static int W; //열
	static char[][] map; //맵
	static int player_row;
	static int player_col;
	static int[] dr = {-1, 0, 1, 0}; //상우하좌
	static int[] dc = {0, 1, 0, -1}; //상우하좌
	static int dir; //방향
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			//input
			for(int i = 0; i < H; i++) {
				String str = sc.next();
				for(int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					//전차 위치를 파악 및 초기 방향 설정
					if(str.charAt(j) == '^' || str.charAt(j) == 'v' || str.charAt(j) == '>' || str.charAt(j) == '<') {
						if(str.charAt(j) == '^')
							dir = 0;
						else if(str.charAt(j) == 'v')
							dir = 2;
						else if(str.charAt(j) == '>')
							dir = 1;
						else
							dir = 3;
						player_row = i;
						player_col = j;
						map[i][j] = '.';
					}
				}
			}
			
			//명령어 입력받기
			int N = sc.nextInt();
			String cmds = sc.next();
			for(int i = 0; i < N; i++) {
				char cmd = cmds.charAt(i);
				if(cmd == 'S') {
					shoot();
				}
				else {
					//방향 바꾸기
					if(cmd == 'U')
						dir = 0;
					else if(cmd == 'D')
						dir = 2;
					else if(cmd == 'R')
						dir = 1;
					else
						dir = 3;
					
					//이동시키기
					if(0 <= player_row + dr[dir] && player_row + dr[dir] < H &&
							0 <= player_col + dc[dir] && player_col + dc[dir] < W &&
							map[player_row + dr[dir]][player_col + dc[dir]] == '.') {
						 player_row += dr[dir];
						 player_col += dc[dir];
					}
				}
			}
			
			//마지막 player 위치 찍기
			if(dir == 0)
				map[player_row][player_col] = '^';
			else if(dir == 1)
				map[player_row][player_col] = '>';
			else if(dir == 2)
				map[player_row][player_col] = 'v';
			else
				map[player_row][player_col] = '<';
			
			//output
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}
	
	static void shoot() {
		int row = player_row;
		int col = player_col;
		
		while(true) {
			row += dr[dir];
			col += dc[dir];
			//범위를 벗어나면
			if(row < 0 || H <= row || col < 0 || W <= col)
				return;
			//벽돌 벽이라면
			else if(map[row][col] == '*') {
				map[row][col] = '.';
				return;
			}
			//강철벽이라면
			else if(map[row][col] == '#') {
				return;
			}
		}
	}
}