package SWEA_1215_회문1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int N = sc.nextInt(); //몇글자 회문인지
			
			//입력값 받기
			String[][] map = new String[8][];
			for(int i = 0; i < 8; i++)
				map[i] = sc.next().split("");
			
			//N == 1일때
			if(N == 1) {
				System.out.println("#" + (t + 1) + " 64");
				continue;
			}
			
			int cnt = 0; //최종 출력값: 회문 갯수
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					//가로 회문 확인
					if(j + N - 1 < 8) {
						int flag = 0;
						for(int k = 0; k < N / 2; k++) {
							if(!(map[i][j + k].equals(map[i][j + N - 1 - k]))) {
								flag = 1; //flag 1: 회문 아님
								break;
							}
						}
						//flag 0: 회문이다
						if(flag == 0)
							cnt++;
					}
					
					//세로 회문 확인
					if(i + N - 1 < 8) {
						int flag = 0;
						for(int k = 0; k < N / 2; k++) {
							if(!(map[i + k][j].equals(map[i + N - 1 - k][j]))) {
								flag = 1; //flag 1: 회문 아님
								break;
							}
						}
						//flag 0: 회문임
						if(flag == 0)
							cnt++;
					}
				}
			}
			System.out.println("#" + (t + 1) + " " + cnt);
		}
		sc.close();
	}
}