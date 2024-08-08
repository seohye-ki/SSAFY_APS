package SWEA_1860_진기의최고급붕어빵;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt(); //손님수
			int M = sc.nextInt(); //붕어빵 만드는데 걸리는 시간
			int K = sc.nextInt(); //한번에 만들수 있는 붕어빵 수
			
			int max = 0; //가장 늦게 오는 손님이 오는 시간
			int[] customer = new int[N]; //언제 손님이 오는지 배열
			//입력받으면서 가장 늦게 오는 시간 구하기
			for(int i = 0; i < N; i++) {
				customer[i] = sc.nextInt();
				if(max < customer[i])
					max = customer[i];
			}
			
			//손님 오는 순서대로 정렬
			Arrays.sort(customer);
			
			//시뮬레이션 돌리기
			int fish = 0;
			int flag = 1; //가능 여부) 1: 가능, 0: 불가능
			int idx = 0; //customer배열 인덱스
			for(int time = 0; time <= max; time++) {
				//붕어빵이 만들어지는 시간이면 갯수 더하기
				if(time != 0 && time % M == 0)
					fish += K;
				//손님들 붕어빵 가져가기
				while(true) {
					//오는 손님 있으면
					if(idx < N && customer[idx] == time) {
						//붕어빵 있을때, 계속 검사하기
						if(fish > 0) {
							fish--;
							idx++;
						}
						//붕어빵 없을때, 불가능 => 더 안보고 종료
						else {
							flag = 0;
							break;
						}
					}
					//오는 손님 없으면
					else
						break;
				}
				if(flag == 0)
					break;
			}
			if(flag == 0)
				System.out.println("#" + (t+1) + " Impossible");
			else
				System.out.println("#" + (t+1) + " Possible");
		}
		
		sc.close();		
	}
}