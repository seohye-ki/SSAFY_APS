package SWEA_5215_햄버거다이어트;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//13:40 ~ 14:30

public class Solution {
	static int N; //재료의 수
	static int L; //제한 칼로리
	static List<int[]> hamberger; //햄버거 정보
	static int max; //최대 맛점수	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			//list생성
			hamberger = new LinkedList<>();
			//햄버거 정보 입력받기 [0]:맛점수 [1]:칼로리
			for(int i = 0; i < N; i++)
				hamberger.add(new int[] {sc.nextInt(), sc.nextInt()});
			//칼로리를 기준으로 정렬하기
			Collections.sort(hamberger, (a, b) -> a[1] - b[1]);
			
			//조합하기
			max = 0;
			comb(0, 0, 0);
			
			//출력
			System.out.println("#" + test_case + " " + max);
		}
		sc.close();
	}
	
	static void comb(int idx, int sumKcal, int sumScore) {
		//칼로리를 넘거나 길이가 N이 되면 그 뒤는 볼필요 없음.
		if(sumKcal > L)
			return;
		if(idx == N) {
			if(max < sumScore)
				max = sumScore;
			return;
		}
		
		//포함하지 않고 계산
		comb(idx + 1, sumKcal, sumScore);
		
		//포함하고 계산
		comb(idx + 1, sumKcal + hamberger.get(idx)[1], sumScore + hamberger.get(idx)[0]);
	}
}