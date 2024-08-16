package swea6485;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt(); //버스 노선 수
			int[] route = new int[5000]; //버스 정류장
			
			//버스 노선 입력하기
			for(int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				for(int j = start - 1; j < end; j++)
					route[j]++;
			}
			
			//출력하고 싶은 정류장
			sb.append("#" + test_case + " ");
			int M = sc.nextInt(); //출력하고 싶은 정류장 수
			for(int i = 0; i < M; i++) {
				int busStop = sc.nextInt(); //정류장
				sb.append(route[busStop - 1] + " ");
			}
			System.out.println(sb);
		}
		sc.close();
	}
}
