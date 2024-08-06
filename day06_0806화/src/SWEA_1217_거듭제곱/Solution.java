package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			int tc = sc.nextInt(); //테스트케이스 번호
			int N = sc.nextInt(); //숫자
			int M = sc.nextInt(); //몇번 곱할지
			result = 1;
			power(N, M);
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
	
	//재귀함수
	static void power(int N, int M) {
		if(M == 0) //M이 0이 된다면 재귀 stop
			return;
		result *= N;
		power(N, M - 1); //M을 하나 줄여서 다시 호출
	}
}