package 문제풀이4;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] client = new int[N];
			
			for(int i = 0; i < N; i++) {
				client[i] = sc.nextInt();
			}
			
			Arrays.sort(client); //quickSort사용함 O(NlogN)
			
			String answer = "Possible";
			
			for(int i = 0; i < N; i++) {
				int time = client[i];
				
				//time / M : 지금까지 붕어빵 만드는 사이클이 몇번 돌았는가?
				//(time / N) * K : 지금까지 만들어진 붕어빵 개수
				//(time/M) * K < i + 1 : 만든 개수가 더 작으면 못먹는 것
				if((time/M) * K < i + 1) {
					answer = "Impossible";
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
		
		sc.close();
	}
}
