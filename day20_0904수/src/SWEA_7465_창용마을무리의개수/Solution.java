package SWEA_7465_창용마을무리의개수;

import java.util.Scanner;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //사람 수
			int M = sc.nextInt(); //관계 정보 개수
			
			//본인을 대표로(MakeSet)
			p = new int[N + 1];
			for(int i = 0; i < N + 1; i++)
				p[i] = i;
			
			//관계 정보 입력받기
			for(int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(x, y);
			}
			
			int answer = 0;
			boolean[] flag = new boolean[N + 1];
			
			//무리 세기
			for(int i = 1; i < N + 1; i++) {
				int idx = findSet(i); //대표찾기
				//등장했던 대표인지 확인
				if(flag[idx] == false) {
					answer++;
					flag[idx] = true;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}
	
	//대표찾기
	static int findSet(int x) {
		if(x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
	
	//합치기
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}