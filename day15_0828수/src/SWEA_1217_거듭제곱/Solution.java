package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt(); //테스트 케이스 번호
			int N = sc.nextInt(); //밑
			int M = sc.nextInt(); //지수
			int answer = power(N, M);
			System.out.println("#" + T + " " + answer);
		}
		sc.close();
	}
	
	static int power(int N, int M) {
		if(N == 0)
			return 0;
		if(M == 0)
			return 1;
		return N * power(N, M - 1);
	}
}