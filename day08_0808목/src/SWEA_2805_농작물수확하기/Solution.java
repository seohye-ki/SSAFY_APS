package SWEA_2805_농작물수확하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt(); //크기

			int minus = N / 2; //버리는 횟수
			int plus = 1; //수확하는 횟수
			int total = 0; //결과값
			
			//0 ~ (N / 2) - 1 줄까지 농작물 수확하기
			for(int i = 0; i < N / 2; i++) {
				String oneline = sc.next();
				for(int j = 0; j < N; j++) {
					//버리기
					for(int k = 0; k < minus; k++)
						j++;
					//수확하기
					for(int k = 0; k < plus; k++) {
						total += (oneline.charAt(j) - '0');
						j++;
					}
					//버리기
					for(int k = 0; k < minus; k++)
						j++;
				}
				minus--;
				plus += 2;
			}
			
			//(N / 2) ~ (N - 1)줄까지 농작물 수확하기
			for(int i = N / 2; i < N; i++) {
				String oneline = sc.next();
				for(int j = 0; j < N; j++) {
					//버리기
					for(int k = 0; k < minus; k++)
						j++;
					//수확하기
					for(int k = 0; k < plus; k++) {
						total += (oneline.charAt(j) - '0');
						j++;
					}
					//버리기
					for(int k = 0; k < minus; k++)
						j++;
				}
				minus++;
				plus -= 2;
			}
			
			//출력
			System.out.println("#" + (t+1) + " " + total);
		}
		sc.close();
	}
}