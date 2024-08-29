package SWEA_6808_규영이와인영이의카드게임;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] ky; //규영이 카드
	static int[] iy; //인영이 카드
	static int win;
	static int lose;
	static boolean[] visited;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			boolean[] card = new boolean[18];
			ky = new int[9];
			iy = new int[9];			
			
			//규영이랑 인영이 카드 분류하기
			for(int i = 0; i < 9; i++) {
				ky[i] = sc.nextInt();
				card[ky[i] - 1] = true;
			}
			int idx = 0;
			for(int i= 0; i < 18; i++) {
				if(card[i] == false)
					iy[idx++] = i + 1;
			}
			
			//순열 조합
			win = 0;
			lose = 0;
			visited = new boolean[9];
			result = new int[9];
			perm(0);
			System.out.println("#" + test_case + " " + win + " " + lose);
		}
		sc.close();
	}
	
	static void perm(int cnt) {
		if(cnt == 9) {
			cardplay();
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				result[cnt] = iy[i];
				perm(cnt + 1);
				visited[i] = false;
			}
		}
	}
	
	static void cardplay() {
		int iy_score = 0;
		int ky_score = 0;
		//게임 진행 스코어 추가
		for(int i = 0; i < 9; i++) {
			if(result[i] > ky[i])
				iy_score += (result[i] + ky[i]);
			else
				ky_score += (result[i] + ky[i]);
		}
		
		//최종 결과
		if(iy_score > ky_score)
			lose++;
		else if(iy_score < ky_score)
			win++;
	}
}