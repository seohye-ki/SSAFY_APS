package SWEA_1216_회문2;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int tc = sc.nextInt(); //테스트 케이스 번호
			
			//입력값 받기
			String[][] map = new String[100][];
			for(int i = 0; i < 100; i++)
				map[i] = sc.next().split("");
			
			//가장 긴 회문 찾기(큰거부터 -1씩 하면서 찾기)
			int N = 100; //회문길이
			int length = 1; //최종 출력값
			out:
			while(N >= 0) {
				for(int i = 0; i < 100; i++) {
					for(int j = 0; j < 100; j++) {
						//가로 회문 확인
						if(j + N - 1 < 100) {
							int flag = 0;
							for(int k = 0; k < N / 2; k++) {
								//바깥쪽부터 같은지 검사
								if(!(map[i][j + k].equals(map[i][j + N - 1 - k]))) {
									flag = 1; //flag 1: 회문 아님
									break;
								}
							}
							//flag 0: 회문이다
							if(flag == 0) {
								length = N;
								break out;
							}
						}
						//세로 회문 확인
						if(i + N - 1 < 100) {
							int flag = 0;
							for(int k = 0; k < N / 2; k++) {
								 //바깥쪽부터 같은지 검사
								if(!(map[i + k][j].equals(map[i + N - 1 - k][j]))) {
									flag = 1; //flag 1: 회문 아님
									break;
								}
							}
							//flag 0: 회문이다
							if(flag == 0) {
								length = N;
								break out;
							}
						}
					}
				}
				N--;
			}
			System.out.println("#" + tc + " " + length);
		}
		sc.close();
	}
}